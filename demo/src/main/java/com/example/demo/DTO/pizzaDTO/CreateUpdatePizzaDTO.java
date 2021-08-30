package com.example.demo.dto.pizzaDTO;

import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
public @Getter @Setter @NoArgsConstructor class CreateUpdatePizzaDTO {
    @NotBlank
    private String name;

    @NotEmpty
    private Set<UUID> ingredients;

}
