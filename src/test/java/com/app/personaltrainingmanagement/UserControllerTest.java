//package com.app.personaltrainingmanagement;
//
//import com.app.personaltrainingmanagement.Subscription.SubscriptionController;
//import com.app.personaltrainingmanagement.User.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.web.servlet.MockMvc;
//
//import javax.validation.ValidationException;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import com.app.personaltrainingmanagement.User.UserDTO;
//import com.app.personaltrainingmanagement.User.UserController;
//import com.app.personaltrainingmanagement.User.UserService;
//
//import java.time.LocalDate;
//
//
//@WebMvcTest(controllers = UserController.class)
//class UserControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserController userController;
//
//    @InjectMocks
//    private SubscriptionController subscriptionController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//
//
//    @Test
//    void getAllUsers_ShouldReturnListOfUsers() {
//        // Arrange
//        List<UserDTO> expectedUsers = Arrays.asList(new UserDTO(), new UserDTO());
//        when(userService.getAllUsers()).thenReturn(expectedUsers);
//
//        // Act
//        List<UserDTO> actualUsers = userController.getAllUsers();
//
//        // Assert
//        assertEquals(expectedUsers, actualUsers);
//    }
//
//    @Test
//    void createUser_ValidUserDTO_ShouldReturnCreatedUser() {
//        // Arrange
//        UserDTO userDTO = new UserDTO();
//        UserDTO createdUser = new UserDTO();
//        when(userService.createUser(userDTO)).thenReturn(createdUser);
//
//        // Act
//        ResponseEntity<UserDTO> response = userController.createUser(userDTO);
//
//        // Assert
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(createdUser, response.getBody());
//    }
//
//    @Test
//    void createUser_InvalidUserDTO_ShouldThrowValidationException() {
//        // Arrange
//        UserDTO invalidUserDTO = new UserDTO();
//        invalidUserDTO.setFirstName(null); // Simulating an invalid user without a name
//
//        // Act & Assert
//        assertThrows(ValidationException.class, () -> userController.createUser(invalidUserDTO));
//        verify(userService, never()).createUser(invalidUserDTO);
//    }
//
//    @Test
//    void updateUser_ExistingUserIdAndValidUserDTO_ShouldReturnUpdatedUser() {
//        // Arrange
//        Long userId = 1L;
//        UserDTO userDTO = new UserDTO();
//        UserDTO updatedUser = new UserDTO();
//        when(userService.updateUser(userId, userDTO)).thenReturn(updatedUser);
//
//        // Act
//        ResponseEntity<UserDTO> response = userController.updateUser(userId, userDTO);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(updatedUser, response.getBody());
//    }
//
//    @Test
//    void updateUser_NonExistingUserId_ShouldReturnNotFoundStatus() {
//        // Arrange
//        Long userId = 1L;
//        UserDTO userDTO = new UserDTO();
//        when(userService.updateUser(userId, userDTO)).thenReturn(null);
//
//        // Act
//        ResponseEntity<UserDTO> response = userController.updateUser(userId, userDTO);
//
//        // Assert
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertNull(response.getBody());
//    }
//    @Test
//    void deleteUser_ExistingUserId_ShouldReturnNoContentStatus() {
//        // Arrange
//        Long userId = 1L;
//
//        // Act
//        ResponseEntity<Void> response = userController.deleteUser(userId);
//
//        // Assert
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        assertNull(response.getBody());
//        verify(userService, times(1)).deleteUserById(userId);
//    }
//}