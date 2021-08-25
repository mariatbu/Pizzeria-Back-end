package com.example.demo.dto.userDTO;

import javax.validation.constraints.NotBlank;

import com.example.demo.domain.userdomain.Rol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class CreateOrUpdateUserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NonNull
    private String password;
    private Rol rol = Rol.ROL_USER;
}
