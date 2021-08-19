package com.example.demo.dto.userDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class CreateOrUpdateUserDTO {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
