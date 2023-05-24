package com.app.personaltrainingmanagement.Trainer;

import com.app.personaltrainingmanagement.Training.Training;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "trainers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Training> trainings = new ArrayList<>();

}

