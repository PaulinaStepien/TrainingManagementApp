package com.app.personaltrainingmanagement;

import com.app.personaltrainingmanagement.User.User;
import com.app.personaltrainingmanagement.User.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Sql(scripts = "classpath:data.sql")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void find_by_email_then_return_user() {
        String email = "user1@example.com";

        Optional<User> foundUser = userRepository.findByEmail(email);

        if (foundUser.isPresent()) {
            User user = foundUser.get();
            System.out.println("User found: " + user.getFirstName() + " " + user.getLastName());
            assertNotNull(user);
        } else {
            System.out.println("User not found.");
        }
    }

    @Test
    public void find_by_phoneNumber_then_return_user() {
        String phoneNumber = "123456789";

        Optional<User> foundUser = userRepository.findByPhoneNumber(phoneNumber);

        if (foundUser.isPresent()) {
            User user = foundUser.get();
            System.out.println("User found: " + user.getFirstName() + " " + user.getLastName());
            assertNotNull(user);
        } else {
            System.out.println("User not found.");
        }
    }

    @Test
    public void find_all() {
        List<User> users = userRepository.findAll();
        assertEquals(3, users.size());
    }


}
