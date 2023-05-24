package com.app.personaltrainingmanagement.Training;

import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public TrainingDTO mapToDto(Training training) {
        TrainingDTO trainingDto = new TrainingDTO();
        trainingDto.setId(training.getId());
        trainingDto.setStartDateTime(training.getStartDateTime());
        trainingDto.setEndDateTime(training.getEndDateTime());
        trainingDto.setStatus(training.getStatus());
        trainingDto.setTrainerId(training.getTrainer().getId());
        if (training.getUser() != null) {
            trainingDto.setUserId(training.getUser().getId());
        }
        return trainingDto;
    }

    public static Training mapToEntity(TrainingDTO trainingDto) {
        Training training = new Training();
        training.setId(trainingDto.getId());
        training.setStartDateTime(trainingDto.getStartDateTime());
        training.setEndDateTime(trainingDto.getEndDateTime());
        training.setStatus(trainingDto.getStatus());
        return training;
    }
}
