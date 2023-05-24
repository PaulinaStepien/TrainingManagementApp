package com.app.personaltrainingmanagement.Training;

import com.app.personaltrainingmanagement.Subscription.Subscription;
import com.app.personaltrainingmanagement.Subscription.SubscriptionDTO;
import com.app.personaltrainingmanagement.Subscription.SubscriptionMapper;
import com.app.personaltrainingmanagement.Trainer.Trainer;
import com.app.personaltrainingmanagement.Trainer.TrainerMapper;
import com.app.personaltrainingmanagement.Trainer.TrainerRepository;
import com.app.personaltrainingmanagement.User.User;
import com.app.personaltrainingmanagement.User.UserDTO;
import com.app.personaltrainingmanagement.User.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;
    private final TrainerRepository trainerRepository;
    private final TrainingMapper trainingMapper;


    @Transactional
    public TrainingDTO createTraining(TrainingDTO trainingDTO) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainingDTO.getTrainerId());
        if (optionalTrainer.isPresent()) {
            Trainer trainer = optionalTrainer.get();
            Training training = TrainingMapper.mapToEntity(trainingDTO);
            training.setTrainer(trainer);
            training.setStatus(TrainingStatusEnum.ACTIVE);
            Training savedTraining = trainingRepository.save(training);
            return trainingMapper.mapToDto(savedTraining);
        } else {
            throw new RuntimeException("User not found");
        }
    }


    @Transactional
    public TrainingDTO updateTraining(Long trainingId, TrainingDTO trainingDTO) {
        Optional<Training> optionalTraining = trainingRepository.findById(trainingId);
        if (optionalTraining.isPresent()) {
            Training training = optionalTraining.get();
            if (trainingDTO.getStartDateTime() != null) {
                training.setStartDateTime(trainingDTO.getStartDateTime());
            }
            if (trainingDTO.getEndDateTime() != null) {
                training.setEndDateTime(trainingDTO.getEndDateTime());
            }
            if (trainingDTO.getUserId() != null) {
                Optional<User> optionalUser = userRepository.findById(trainingDTO.getUserId());
                if (optionalUser.isPresent()) {
                    User user = optionalUser.get();
                    training.setUser(user);
                    training.setStatus(TrainingStatusEnum.RESERVED);
                }
            }
            Training updatedTraining = trainingRepository.save(training);
            return trainingMapper.mapToDto(updatedTraining);
        } else {
            throw new RuntimeException("Training not found");
        }
    }


    @Transactional
    public void deleteTraining(Long trainingId) {
        trainingRepository.deleteById(trainingId);
    }

    @Transactional
    public TrainingDTO getTrainingById(Long trainingId) {
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return trainingMapper.mapToDto(training);
    }


    @Transactional
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }
}
