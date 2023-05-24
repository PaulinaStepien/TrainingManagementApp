package com.app.personaltrainingmanagement.Trainer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository, TrainerMapper trainerMapper) {
        this.trainerRepository = trainerRepository;
        this.trainerMapper = trainerMapper;
    }

    @Transactional
    public List<TrainerDTO> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream()
                .map(trainerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TrainerDTO getTrainerById(Long id) {
        try {
            Trainer trainer = trainerRepository.findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            return trainerMapper.mapToDto(trainer);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Trainer not found", e);
        }
    }

    @Transactional
    public TrainerDTO createTrainer(TrainerDTO trainerDTO) {
        Trainer trainer = trainerMapper.mapToEntity(trainerDTO);
        Trainer savedTrainer = trainerRepository.save(trainer);
        return trainerMapper.mapToDto(savedTrainer);
    }

    @Transactional
    public TrainerDTO updateTrainer(Long trainerId, TrainerDTO trainerDTO) {
        Trainer existingTrainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new NoSuchElementException("Trainer not found with id: " + trainerId));

        if (trainerDTO.getEmail() != null) {
            existingTrainer.setEmail(trainerDTO.getEmail());
        }

        if (trainerDTO.getFirstName() != null) {
            existingTrainer.setFirstName(trainerDTO.getFirstName());
        }

        if (trainerDTO.getLastName() != null) {
            existingTrainer.setLastName(trainerDTO.getLastName());
        }

        Trainer updatedTrainer = trainerRepository.save(existingTrainer);
        return trainerMapper.mapToDto(updatedTrainer);
    }


    @Transactional
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }

    @Transactional
    public TrainerDTO getTrainerByEmail(String email) {
        Trainer trainer = trainerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        return trainerMapper.mapToDto(trainer);
    }
}

