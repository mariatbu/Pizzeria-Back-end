package com.example.demo.dto.userDTO;

import javax.validation.constraints.NotBlank;

import com.example.demo.domain.userdomain.Rol;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
public @Getter @Setter @NoArgsConstructor class CreateOrUpdateUserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Rol rol = Rol.ROL_USER;
}
