package pl.wsb.fitnesstracker.training.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import pl.wsb.fitnesstracker.training.internal.ActivityType;

import java.time.LocalDate;
import java.util.Date;

/**
 * The type Training dto.
 */
public record TrainingDto (@Nullable Long id, TrainingUserDto user, Date startTime, Date endTime, ActivityType activityType, double distance,  double averageSpeed) {

}
