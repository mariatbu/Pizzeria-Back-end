package com.example.demo.dto.userDTO;

import javax.validation.constraints.NotBlank;


import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
public @Getter @Setter @NoArgsConstructor class UpdateUserDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String oldPassword;
    @NotBlank
    private String newPassword;
}
