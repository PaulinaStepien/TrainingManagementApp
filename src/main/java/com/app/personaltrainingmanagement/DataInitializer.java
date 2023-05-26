package com.app.personaltrainingmanagement;

import com.app.personaltrainingmanagement.Subscription.SubscriptionDTO;
import com.app.personaltrainingmanagement.Subscription.SubscriptionService;
import com.app.personaltrainingmanagement.Subscription.SubscriptionTypeEnum;
import com.app.personaltrainingmanagement.Trainer.TrainerDTO;
import com.app.personaltrainingmanagement.Trainer.TrainerService;
import com.app.personaltrainingmanagement.Training.*;
import com.app.personaltrainingmanagement.User.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final TrainerService trainerService;
    private final TrainingService trainingService;


    @Override
    public void run(String... args) {
        initializeUsers();
        initializeSubscriptions();
        initializeTrainers();
        initializeTrainings();
    }

    private void initializeUsers() {
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setEmail("user1@example.com");
        userDTO1.setPassword("password1");
        userDTO1.setFirstName("John");
        userDTO1.setLastName("Doe");
        userDTO1.setBirthdate(LocalDate.of(1994, 5, 1));
        userDTO1.setPhoneNumber("123456789");

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setEmail("user2@example.com");
        userDTO2.setPassword("password2");
        userDTO2.setFirstName("Jane");
        userDTO2.setLastName("Smith");
        userDTO2.setBirthdate(LocalDate.of(2000, 5, 1));
        userDTO2.setPhoneNumber("123456781");

        userService.createUser(userDTO1);
        userService.createUser(userDTO2);

    }

    private void initializeTrainers() {
        TrainerDTO trainerDTO1 = new TrainerDTO();
        trainerDTO1.setEmail("user1@example.com");
        trainerDTO1.setFirstName("John");
        trainerDTO1.setLastName("Doe");
        trainerService.createTrainer(trainerDTO1);

    }

    private void initializeSubscriptions() {
        SubscriptionDTO subscriptionDTO1 = new SubscriptionDTO();
        subscriptionDTO1.setSubscriptionType(SubscriptionTypeEnum.SIX);
        subscriptionDTO1.setBeginDate(LocalDate.of(2023, 6, 30));
        subscriptionDTO1.setEndDate(LocalDate.of(2023, 7, 30));
        subscriptionDTO1.setStatus("Active");
        subscriptionDTO1.setUserId(1L);

        SubscriptionDTO subscriptionDTO2 = new SubscriptionDTO();
        subscriptionDTO2.setSubscriptionType(SubscriptionTypeEnum.FOUR);
        subscriptionDTO2.setBeginDate(LocalDate.of(2023, 8, 30));
        subscriptionDTO2.setEndDate(LocalDate.of(2023, 9, 30));
        subscriptionDTO2.setStatus("Inactive");
        subscriptionDTO2.setUserId(1L);

        subscriptionService.createSubscription(subscriptionDTO1);
        subscriptionService.createSubscription(subscriptionDTO2);
    }

    private void initializeTrainings() {
        TrainingDTO trainingDTO1 = new TrainingDTO();
        trainingDTO1.setStartDateTime(LocalDateTime.of(2023,5,26,17,0));
        trainingDTO1.setEndDateTime(LocalDateTime.of(2023,5,26,18,0));
        trainingDTO1.setStatus(TrainingStatusEnum.ACTIVE);
        trainingDTO1.setUserId(1L);
        trainingDTO1.setTrainerId(1L);


        TrainingDTO trainingDTO2 = new TrainingDTO();
        trainingDTO2.setStartDateTime(LocalDateTime.of(2023,5,27,17,0));
        trainingDTO2.setEndDateTime(LocalDateTime.of(2023,5,27,18,0));
        trainingDTO2.setTrainerId(1L);

        trainingService.createTraining(trainingDTO1);
        trainingService.createTraining(trainingDTO2);

    }


}
