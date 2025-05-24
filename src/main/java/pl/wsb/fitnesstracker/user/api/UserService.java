package pl.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    User createUser(User user);

    /**
     * Update user.
     *
     * @param user the user
     */
    void updateUser(UserDto user);

}
