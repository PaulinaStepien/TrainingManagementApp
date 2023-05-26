package com.app.personaltrainingmanagement.User;// User.java
import com.app.personaltrainingmanagement.Subscription.Subscription;
import com.app.personaltrainingmanagement.Training.Training;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have at least 6 characters", max = 20)
    @Column(length = 20, nullable = false)
    private String password;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @NotNull(message = "Birthdate is required")
    @Past(message = "Birthdate must be in the past")
    @Column(nullable = false)
    private LocalDate birthdate;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{9}", message = "Invalid phone number")
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Training> trainings = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Subscription> subscriptions = new ArrayList<>();

    public User(long id, String firstName, String lastName, String email, String birthdate, String phoneNumber, String password) {
    }
}
