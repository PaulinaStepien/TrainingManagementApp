package com.app.personaltrainingmanagement.Subscription;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionDTO> createSubscription(@Valid @RequestBody SubscriptionDTO subscriptionDTO) {
        SubscriptionDTO createdSubscription = subscriptionService.createSubscription(subscriptionDTO);
        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
    }



    @GetMapping("/{subscriptionId}")
    public ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable Long subscriptionId) {
        SubscriptionDTO subscription = subscriptionService.getSubscriptionbyID(subscriptionId);
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }

}
