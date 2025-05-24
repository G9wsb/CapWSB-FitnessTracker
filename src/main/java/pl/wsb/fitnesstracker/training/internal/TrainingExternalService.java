package pl.wsb.fitnesstracker.training.internal;

import pl.wsb.fitnesstracker.user.api.User;

import java.util.Optional;

/**
 * The interface Training external service.
 */
public interface TrainingExternalService {
    /**
     * Delete trainings by user id.
     *
     * @param userId the user id
     */
    void deleteTrainingsByUserId(Long userId);
}
