package com.app.personaltrainingmanagement.Training;
import com.app.personaltrainingmanagement.Trainer.Trainer;
import com.app.personaltrainingmanagement.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "training")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @NotNull(message = "Start date and time is required")
    @Future(message = "Start date and time must be in the future")
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @NotNull(message = "End date and time is required")
    @Future(message = "End date and time must be in the future")
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TrainingStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Training(Long id, LocalDateTime startDateTime, LocalDateTime endDateTime, TrainingStatusEnum status, Trainer trainer) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.status = status;
        this.trainer = trainer;
    }

}