package com.app.personaltrainingmanagement;

import com.app.personaltrainingmanagement.Trainer.Trainer;
import com.app.personaltrainingmanagement.Trainer.TrainerRepository;
import com.app.personaltrainingmanagement.User.User;
import com.app.personaltrainingmanagement.User.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@Sql(scripts = "classpath:data.sql")
public class TrainerRepositoryTest {

    @Autowired
    private TrainerRepository trainerRepository;


    @Test
    public void find_by_email_then_return_trainer() {
        String email = "john.doe@example.com";

        Optional<Trainer> foundTrainer = trainerRepository.findByEmail(email);

        if (foundTrainer.isPresent()) {
            Trainer trainer = foundTrainer.get();
            System.out.println("Trainer found: " + trainer.getFirstName() + " " + trainer.getLastName());
        } else {
            System.out.println("User not found.");
        }
    }


    @Test
    public void find_all() {
        List<Trainer> trainers = trainerRepository.findAll();
        assertEquals(3, trainers.size());
    }

}
