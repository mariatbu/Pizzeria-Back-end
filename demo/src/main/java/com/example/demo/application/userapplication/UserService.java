package com.example.demo.application.userapplication;

import java.util.UUID;

import com.example.demo.domain.userdomain.User;
import com.example.demo.dto.userDTO.CreateOrUpdateUserDTO;
import com.example.demo.dto.userDTO.UserDTO;

public class UserService {

    public static User create(CreateOrUpdateUserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRol(dto.getRol());
        user.setId(UUID.randomUUID());
        return user;
    }
    public static UserDTO createDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRol(user.getRol());
        dto.setId(UUID.randomUUID());
        return dto;
    }
    
}
