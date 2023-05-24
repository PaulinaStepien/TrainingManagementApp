package com.app.personaltrainingmanagement.Training;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class TrainingDTO {
    private Long id;
    private TrainingStatusEnum status;
    private Long userId;

    @NotNull(message = "Start date and time is required")
    @Future(message = "Start date and time must be in the future")
    private LocalDateTime startDateTime;

    @NotNull(message = "End date and time is required")
    @Future(message = "End date and time must be in the future")
    private LocalDateTime endDateTime;

    @NotNull(message = "Trainer ID is required")
    private Long trainerId;


}
