package pl.wsb.fitnesstracker.training.internal;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.training.api.TrainingDtoWithUserId;
import pl.wsb.fitnesstracker.training.api.TrainingDto;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.internal.UserExternalServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

/**
 * The type Training controller.
 */
@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingServiceImpl trainingService;

    private final TrainingMapper trainingMapper;

    private final UserExternalServiceImpl userExternalService;

    /**
     * Gets all trainings.
     *
     * @return the all trainings
     */
    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        return trainingService.findAllTrainings().stream().map(trainingMapper::toDto).toList();
    }

    /**
     * Gets user trainings.
     *
     * @param userId the user id
     * @return the user trainings
     */
    @GetMapping("/{userId}")
    public List<TrainingDto> getUserTrainings(@PathVariable Long userId) {
        return trainingService.findTrainingsByUserId(userId).stream().map(trainingMapper::toDto).toList();
    }

    /**
     * Gets trainings after time.
     *
     * @param afterTime the after time
     * @return the trainings after time
     * @throws ParseException the parse exception
     */
    @GetMapping("/finished/{afterTime}")
    public List<TrainingDto> getTrainingsAfterTime(@PathVariable String afterTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        return trainingService.findTrainingsFinishedAfter(sdf.parse(afterTime)).stream().map(trainingMapper::toDto).toList();
    }

    /**
     * Gets trainings by activity.
     *
     * @param activityType the activity type
     * @return the trainings by activity
     * @throws ParseException the parse exception
     */
    @GetMapping("/activityType")
    public List<TrainingDto> getTrainingsByActivity(@RequestParam ActivityType activityType) throws ParseException {
        return trainingService.findTrainingsByActivity(activityType).stream().map(trainingMapper::toDto).toList();
    }


    /**
     * Create training training dto.
     *
     * @param trainingDtoWithUserId the training dto with user id
     * @return the training dto
     * @throws ParseException the parse exception
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingDto createTraining(@RequestBody TrainingDtoWithUserId trainingDtoWithUserId) throws ParseException {
        Optional<User> userOptional = userExternalService.getUserById(trainingDtoWithUserId.userId());
        if(userOptional.isPresent()){
            return trainingService.createTraining(trainingDtoWithUserId, userOptional.get());
        }

        return null;
    }


    /**
     * Update training training dto.
     *
     * @param trainingId            the training id
     * @param trainingDtoWithUserId the training dto with user id
     * @return the training dto
     * @throws ParseException the parse exception
     */
    @PutMapping("/{trainingId}")
    public TrainingDto updateTraining(@PathVariable Long trainingId, @RequestBody TrainingDtoWithUserId trainingDtoWithUserId) throws ParseException {
        return trainingService.updateTraining(trainingId, trainingDtoWithUserId);
    }
}
