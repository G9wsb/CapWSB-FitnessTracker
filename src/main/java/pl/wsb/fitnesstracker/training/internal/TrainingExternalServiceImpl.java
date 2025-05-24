package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.Training;

import java.util.List;

/**
 * The type User external service.
 */
@Service
@RequiredArgsConstructor
public class TrainingExternalServiceImpl implements TrainingExternalService {

    private final TrainingServiceImpl trainingService;

    private final TrainingRepository trainingRepository;

    @Override
    public void deleteTrainingsByUserId(Long userId) {
        List<Training> trainings = trainingService.findTrainingsByUserId(userId);
        trainingRepository.deleteAllInBatch(trainings);
    }
}
