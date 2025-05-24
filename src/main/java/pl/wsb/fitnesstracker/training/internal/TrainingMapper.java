package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.TrainingDtoWithUserId;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDto;
import pl.wsb.fitnesstracker.training.api.TrainingUserDto;
import pl.wsb.fitnesstracker.user.api.User;

/**
 * The type Training mapper.
 */
@Component
@RequiredArgsConstructor
public class TrainingMapper {

    private final TrainingUserMapper trainingUserMapper;

    /**
     * To dto training dto.
     *
     * @param training the training
     * @return the training dto
     */
    TrainingDto toDto(Training training) {
        return new TrainingDto(training.getId(), trainingUserMapper.toDto(training.getUser()) , training.getStartTime(), training.getEndTime(), training.getActivityType(), training.getDistance(),  training.getAverageSpeed());
    }

    /**
     * To entity training.
     *
     * @param trainingDto the training dto
     * @param user        the user
     * @return the training
     */
    Training toEntity(TrainingDtoWithUserId trainingDto, User user) {
        return new Training(user, trainingDto.startTime(), trainingDto.endTime(), trainingDto.activityType(), trainingDto.distance(), trainingDto.averageSpeed());

    }

    /**
     * To entity user.
     *
     * @param trainingUserDto the training user dto
     * @return the user
     */
    User toEntity(TrainingUserDto trainingUserDto) {
        return new User(trainingUserDto.firstName(), trainingUserDto.lastName(), trainingUserDto.birthdate(), trainingUserDto.email());
    }
}
