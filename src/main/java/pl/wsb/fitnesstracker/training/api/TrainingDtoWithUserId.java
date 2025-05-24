package pl.wsb.fitnesstracker.training.api;

import jakarta.annotation.Nullable;
import pl.wsb.fitnesstracker.training.internal.ActivityType;

import java.util.Date;

/**
 * The type Training dto with user id.
 */
public record TrainingDtoWithUserId(@Nullable Long id, Long userId, Date startTime, Date endTime, ActivityType activityType, double distance, double averageSpeed) {

}
