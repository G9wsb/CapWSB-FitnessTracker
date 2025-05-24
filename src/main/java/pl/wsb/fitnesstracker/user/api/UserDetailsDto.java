package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

/**
 * The type User details dto.
 */
public record UserDetailsDto(@Nullable Long id, String username, String birthDate) {

}
