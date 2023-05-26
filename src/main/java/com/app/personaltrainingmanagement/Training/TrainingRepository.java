package com.app.personaltrainingmanagement.Training;

import com.app.personaltrainingmanagement.Trainer.Trainer;
import com.app.personaltrainingmanagement.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {

//    List<Training> findAllByUser(User user);
//    List<Training> findAllByTrainer(Trainer trainer);


    List<Training> findByUserAndStatus(User user, TrainingStatusEnum reserved);

    List<Training> findByTrainerAndStatus(Trainer trainer, TrainingStatusEnum status);

}
