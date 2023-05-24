package com.app.personaltrainingmanagement.User;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;
    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
    }

    @Test
    void createUser() {
        // Given
        UserDTO userDTO = new UserDTO();
        User savedUser = new User();


        when(userService.createUser(any(UserDTO.class))).thenReturn(userDTO);

        // When
        ResponseEntity<UserDTO> responseEntity = userController.createUser(userDTO);
        HttpStatus statusCode = responseEntity.getStatusCode();
        UserDTO createdUserDTO = responseEntity.getBody();

        // Then
        assertEquals(HttpStatus.CREATED, statusCode);
        assertEquals(savedUser, userMapper.mapToEntity(createdUserDTO));
    }
}


//
//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void deleteUser() {
//    }
//
//    @Test
//    void getUser() {
//    }
//}