package com.example.demo.dto.pizzaDTO;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
public @Getter @Setter @NoArgsConstructor class UpdatePizzaDTO {
    @NotBlank
    private String name;

}
