package com.app.personaltrainingmanagement.Training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public ResponseEntity<TrainingDTO> createTraining( @RequestBody TrainingDTO trainingDTO) {
        TrainingDTO createdTraining = trainingService.createTraining(trainingDTO);
        return new ResponseEntity<>(createdTraining, HttpStatus.CREATED);
    }


    @PutMapping("/{trainingId}")
    public ResponseEntity<TrainingDTO> updateTraining(@PathVariable Long trainingId, @RequestBody TrainingDTO trainingDTO) {
        TrainingDTO updatedTraining = trainingService.updateTraining(trainingId, trainingDTO);
        return new ResponseEntity<>(updatedTraining, HttpStatus.OK);
    }

    @DeleteMapping("/{trainingId}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long trainingId) {
        trainingService.deleteTraining(trainingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byId/{trainingId}")
    public ResponseEntity<TrainingDTO> getTraining(@PathVariable Long trainingId) {
        TrainingDTO training = trainingService.getTrainingById(trainingId);
        return new ResponseEntity<>(training, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}/reservedTrainings")
    public ResponseEntity<List<TrainingDTO>> getReservedTrainingsForUser(@PathVariable Long userId) {
        List<TrainingDTO> cancelledTrainings = trainingService.getReservedTrainingsForUser(userId);
        return new ResponseEntity<>(cancelledTrainings, HttpStatus.OK);
    }

    @GetMapping("/trainer/{trainerId}/reservedTrainings")
    public ResponseEntity<List<TrainingDTO>> getReservedTrainingsForTrainer(@PathVariable Long trainerId) {
        List<TrainingDTO> reservedTrainings = trainingService.getReservedTrainingsForTrainer(trainerId);
        return new ResponseEntity<>(reservedTrainings, HttpStatus.OK);
    }

    @GetMapping("/trainer/{trainerId}/activeTrainings")
    public ResponseEntity<List<TrainingDTO>> getActiveTrainingsForTrainer(@PathVariable Long trainerId) {
        List<TrainingDTO> activeTrainings = trainingService.getActiveTrainingsForTrainer(trainerId);
        return new ResponseEntity<>(activeTrainings, HttpStatus.OK);
    }
}

