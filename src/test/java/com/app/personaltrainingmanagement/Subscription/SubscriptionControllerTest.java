//package com.app.personaltrainingmanagement.Subscription;
//
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//class SubscriptionControllerTest {
//
//    @Test
//    void createSubscription() {
//        // Given
//        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
//        subscriptionDTO.setId(1L);
//        subscriptionDTO.setSubscriptionType(SubscriptionTypeEnum.FOUR); // Ustawienie poprawnego typu SubscriptionTypeEnum
//        subscriptionDTO.setBeginDate(LocalDate.now());
//        subscriptionDTO.setEndDate(LocalDate.now().plusMonths(1));
//        subscriptionDTO.setUserId(1L);
//
//        SubscriptionService subscriptionService = mock(SubscriptionService.class);
//        when(subscriptionService.createSubscription(subscriptionDTO)).thenReturn(subscriptionDTO);
//
//        SubscriptionController subscriptionController = new SubscriptionController(subscriptionService);
//
//        // When
//        SubscriptionDTO result = subscriptionController.createSubscription(subscriptionDTO);
//
//        // Then
//        assertEquals(1L, result.getId());
//        assertEquals(SubscriptionTypeEnum.FOUR, result.getSubscriptionType()); // Sprawdzenie poprawnego typu SubscriptionTypeEnum
//        assertEquals(LocalDate.now(), result.getBeginDate());
//        assertEquals(LocalDate.now().plusMonths(1), result.getEndDate());
//        assertEquals(1L, result.getUserId());
//    }
//
//
//    @Test
//    void updateSubscription() {
//    }
//
//    @Test
//    void deleteSubscription() {
//    }
//
//    @Test
//    void getSubscription() {
//    }
//}