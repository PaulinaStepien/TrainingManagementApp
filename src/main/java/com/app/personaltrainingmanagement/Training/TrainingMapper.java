package com.app.personaltrainingmanagement.Training;// Pakiet com.app.personaltrainingmanagement.Training

import com.app.personaltrainingmanagement.Trainer.Trainer;
import com.app.personaltrainingmanagement.Training.Training;
import com.app.personaltrainingmanagement.Training.TrainingDTO;
import com.app.personaltrainingmanagement.User.User;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public TrainingDTO mapToDto(Training training) {
        TrainingDTO trainingDto = new TrainingDTO();
        trainingDto.setId(training.getId());
        trainingDto.setStartDateTime(training.getStartDateTime());
        trainingDto.setEndDateTime(training.getEndDateTime());
        trainingDto.setStatus(training.getStatus());

        Trainer trainer = training.getTrainer();
        if (trainer != null) {
            trainingDto.setTrainerId(trainer.getId());
        } else {
            trainingDto.setTrainerId(null);
        }

        User user = training.getUser();
        if (user != null) {
            trainingDto.setUserId(user.getId());
        } else {
            trainingDto.setUserId(null);
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
