package pl.wsb.fitnesstracker.training.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

/**
 * The type Training user dto.
 */
public record TrainingUserDto(@Nullable Long id, String firstName, String lastName,
                              @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                              String email) {

}
