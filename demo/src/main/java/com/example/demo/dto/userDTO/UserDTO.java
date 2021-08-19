package com.example.demo.dto.userDTO;

import com.example.demo.domain.userdomain.Rol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

public @Getter @Setter @NoArgsConstructor class UserDTO {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Rol rol;
}
