package com.app.personaltrainingmanagement.Subscription;

import com.app.personaltrainingmanagement.User.User;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {
    public SubscriptionDTO mapToDto(Subscription subscription) {
        SubscriptionDTO subscriptionDto = new SubscriptionDTO();
        subscriptionDto.setId(subscription.getId());
        subscriptionDto.setSubscriptionType(subscription.getSubscriptionType());
        subscriptionDto.setBeginDate(subscription.getBeginDate());
        subscriptionDto.setEndDate(subscription.getEndDate());
        subscriptionDto.setStatus(subscription.getStatus());
        subscriptionDto.setUserId(subscription.getUser().getId());
        return subscriptionDto;
    }

    public static Subscription mapToEntity(SubscriptionDTO subscriptionDto) {
        Subscription subscription = new Subscription();
        subscription.setId(subscriptionDto.getId());
        subscription.setSubscriptionType(subscriptionDto.getSubscriptionType());
        subscription.setBeginDate(subscriptionDto.getBeginDate());
        subscription.setEndDate(subscriptionDto.getEndDate());
        subscription.setStatus(subscriptionDto.getStatus());

        User user = new User();
        user.setId(subscriptionDto.getUserId());
        subscription.setUser(user);

        return subscription;
    }
}
