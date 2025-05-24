package pl.wsb.fitnesstracker.user.internal;

import pl.wsb.fitnesstracker.user.api.User;

import java.util.Optional;

/**
 * The interface User external service.
 */
public interface UserExternalService {

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    Optional<User> getUserById(Long userId);
}
