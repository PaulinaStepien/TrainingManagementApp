package com.app.personaltrainingmanagement.Training;

import com.app.personaltrainingmanagement.Trainer.Trainer;
import com.app.personaltrainingmanagement.Trainer.TrainerRepository;
import com.app.personaltrainingmanagement.User.User;
import com.app.personaltrainingmanagement.User.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            if (trainingDTO.getUserId() == null) {
                training.setStatus(TrainingStatusEnum.ACTIVE);
            } else {
                Optional<User> optionalUser = userRepository.findById(trainingDTO.getUserId());
                if (optionalUser.isPresent()) {
                    User user = optionalUser.get();
                    training.setUser(user);
                    training.setStatus(TrainingStatusEnum.RESERVED);
                } else {
                    throw new RuntimeException("User not found");
                }
            }
            Training savedTraining = trainingRepository.save(training);
            return trainingMapper.mapToDto(savedTraining);
        } else {
            throw new RuntimeException("Trainer not found");
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

            Long newUserId = trainingDTO.getUserId();
            if (newUserId != null) {
                User newUser = userRepository.findById(newUserId)
                        .orElseThrow(() -> new RuntimeException("User not found"));
                training.setUser(newUser);
                training.setStatus(TrainingStatusEnum.RESERVED);
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
    public List<TrainingDTO> getReservedTrainingsForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Training> reservedTrainings = trainingRepository.findByUserAndStatus(user, TrainingStatusEnum.RESERVED);

        TrainingMapper trainingMapper = new TrainingMapper();

        return reservedTrainings.stream()
                .map(trainingMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TrainingDTO> getReservedTrainingsForTrainer(Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        List<Training> reservedTrainings = trainingRepository.findByTrainerAndStatus(trainer, TrainingStatusEnum.RESERVED);

        TrainingMapper trainingMapper = new TrainingMapper();

        return reservedTrainings.stream()
                .map(trainingMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TrainingDTO> getActiveTrainingsForTrainer(Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        List<Training> activeTrainings = trainingRepository.findByTrainerAndStatus(trainer, TrainingStatusEnum.ACTIVE);

        TrainingMapper trainingMapper = new TrainingMapper();

        return activeTrainings.stream()
                .map(trainingMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
