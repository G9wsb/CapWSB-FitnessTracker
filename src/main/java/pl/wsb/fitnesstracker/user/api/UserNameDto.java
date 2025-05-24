package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

/**
 * The type User name dto.
 */
public record UserNameDto(@Nullable Long id, String firstName, String lastName) {

}
