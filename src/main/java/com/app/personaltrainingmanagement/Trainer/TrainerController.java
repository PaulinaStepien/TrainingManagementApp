package com.app.personaltrainingmanagement.Trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {


    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    public ResponseEntity<TrainerDTO> createTrainer(@Valid @RequestBody TrainerDTO trainerDTO) {
        TrainerDTO createdTrainer = trainerService.createTrainer(trainerDTO);
        return new ResponseEntity<>(createdTrainer, HttpStatus.CREATED);
    }

    @PutMapping("/{trainerId}")
    public ResponseEntity<TrainerDTO> updateTrainer(@PathVariable Long trainerId, @Valid @RequestBody TrainerDTO trainerDto) {
        TrainerDTO updatedTrainer = trainerService.updateTrainer(trainerId, trainerDto);
        return new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
    }

    @DeleteMapping("/{trainerId}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long trainerId) {
        trainerService.deleteTrainer(trainerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/allTrainers")
    public List<TrainerDTO> getAllTrainers() {
        return trainerService.getAllTrainers();
    }
    @GetMapping("/{trainerId}")
    public ResponseEntity<TrainerDTO> getTrainerById(@PathVariable Long trainerId) {
        TrainerDTO trainerDTO = trainerService.getTrainerById(trainerId);
        return new ResponseEntity<>(trainerDTO, HttpStatus.OK);
    }

    @GetMapping("/byEmail/{trainerEmail}")
    public ResponseEntity<TrainerDTO> getTrainerByEmail(@PathVariable String trainerEmail) {
        TrainerDTO trainer = trainerService.getTrainerByEmail(trainerEmail);
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }
}

