package com.example.demo.application.userapplication;

import java.util.UUID;

import com.example.demo.domain.userdomain.User;
import com.example.demo.dto.userDTO.CreateOrUpdateUserDTO;
import com.example.demo.dto.userDTO.UserDTO;

public class UserService {

    public static User create(CreateOrUpdateUserDTO dto) {
        User user = new User();
        /*user.name = dto.name;
        user.lastName = dto.lastName;
        user.email = dto.email;
        user.id = UUID.randomUUID();*/
        return user;
    }
    public static UserDTO createDTO(User user){
        UserDTO dto = new UserDTO();
        /*dto.id = user.id;
        dto.name = user.name;
        dto.lastName = user.lastName;
        dto.email = user.email;*/
        return dto;
    }
    
}
