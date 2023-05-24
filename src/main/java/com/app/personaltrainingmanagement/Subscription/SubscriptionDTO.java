package com.app.personaltrainingmanagement.Subscription;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
public class SubscriptionDTO {

    private Long id;
    @NotNull(message = "Subscription type is required")
    private SubscriptionTypeEnum subscriptionType;

    @NotNull(message = "Begin date is required")
    private LocalDate beginDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    private String status;
    private Long userId;
}
