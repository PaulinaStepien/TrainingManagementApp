package com.app.personaltrainingmanagement.Trainer;

import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {

    public TrainerDTO mapToDto(Trainer trainer) {
        TrainerDTO trainerDto = new TrainerDTO();
        trainerDto.setId(trainer.getId());
        trainerDto.setEmail(trainer.getEmail());
        trainerDto.setFirstName(trainer.getFirstName());
        trainerDto.setLastName(trainer.getLastName());
        return trainerDto;
    }

    public Trainer mapToEntity(TrainerDTO trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setId(trainerDto.getId());
        trainer.setEmail(trainerDto.getEmail());
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        return trainer;
    }
}

