package com.example.demo.DTO.userDTO;

import java.util.UUID;

import com.example.demo.domain.userdomain.Rol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public @Getter @Setter @NoArgsConstructor class UserDTO {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Rol rol = Rol.ROL_USER;
}
