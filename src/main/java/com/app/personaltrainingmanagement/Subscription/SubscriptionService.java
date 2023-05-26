package com.app.personaltrainingmanagement.Subscription;

import com.app.personaltrainingmanagement.User.User;
import com.app.personaltrainingmanagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository, UserRepository userRepository, SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    @Transactional
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        Optional<User> optionalUser = userRepository.findById(subscriptionDTO.getUserId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Subscription subscription = SubscriptionMapper.mapToEntity(subscriptionDTO);
            subscription.setUser(user);
            Subscription savedSubscription = subscriptionRepository.save(subscription);
            return subscriptionMapper.mapToDto(savedSubscription);
        } else {
            throw new RuntimeException("User not found");
        }
    }


    @Transactional
    public SubscriptionDTO getSubscriptionByID(Long subscriptionId) {
        try {
            Subscription subscription = subscriptionRepository.findById(subscriptionId)
                    .orElseThrow(EntityNotFoundException::new);
            return subscriptionMapper.mapToDto(subscription);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Subscription not found", e);
        }
    }





}
