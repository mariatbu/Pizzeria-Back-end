package com.example.demo.dto.userDTO;

import com.example.demo.domain.userdomain.Rol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class CreateOrUpdateUserDTO {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Rol rol = Rol.ROL_USER;
}
