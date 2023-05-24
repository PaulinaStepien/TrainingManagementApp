package com.app.personaltrainingmanagement.User;


import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO mapToDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthdate(user.getBirthdate());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }

    public User mapToEntity(UserDTO userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthdate(userDto.getBirthdate());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }
}
