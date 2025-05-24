package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Training service.
 */
@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingProvider {

    private final TrainingRepository trainingRepository;

    private final TrainingMapper trainingMapper;

    private final TrainingUserMapper trainingUserMapper;

    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }

    /**
     * Create training training dto.
     *
     * @param trainingDto the training dto
     * @param user        the user
     * @return the training dto
     */
    public TrainingDto createTraining(TrainingDtoWithUserId trainingDto, User user) {
        Training training = trainingMapper.toEntity(trainingDto, user);
        Training savedTraining = trainingRepository.save(training);
        return trainingMapper.toDto(savedTraining);
    }

    /**
     * Update training training dto.
     *
     * @param trainingId  the training id
     * @param trainingDto the training dto
     * @return the training dto
     */
    public TrainingDto updateTraining(Long trainingId, TrainingDtoWithUserId trainingDto) {
        Training training = trainingRepository.getReferenceById(trainingId);

        training.setStartTime(trainingDto.startTime());
        training.setEndTime(trainingDto.endTime());
        training.setActivityType(trainingDto.activityType());
        training.setDistance(trainingDto.distance());
        training.setAverageSpeed(trainingDto.averageSpeed());

        return trainingMapper.toDto(trainingRepository.save(training));
    }

    /**
     * Find all trainings list.
     *
     * @return the list
     */
    public List<Training> findAllTrainings() {
        return trainingRepository.findAll();
    }

    /**
     * Find trainings by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    public List<Training> findTrainingsByUserId(Long userId) {
        return trainingRepository.findAll().stream().filter(training -> training.getUser().getId().equals(userId)).toList();
    }

    /**
     * Find trainings finished after list.
     *
     * @param afterTime the after time
     * @return the list
     */
    public List<Training> findTrainingsFinishedAfter(Date afterTime) {
        return trainingRepository.findAll().stream().filter(training -> training.getStartTime().after(afterTime)).toList();
    }

    /**
     * Find trainings by activity list.
     *
     * @param activityType the activity type
     * @return the list
     */
    public List<Training> findTrainingsByActivity(ActivityType activityType) {
        return trainingRepository.findAll().stream().filter(training -> training.getActivityType().equals(activityType)).toList();
    }

}
