package com.example.demo.application.pizzaapplication;

import java.util.UUID;

import com.example.demo.dto.pizzaDTO.CreateUpdatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;

public interface PizzaApplication {
    public PizzaDTO add(CreateUpdatePizzaDTO dto);
    public PizzaDTO get(UUID id);
    public PizzaDTO update(UUID id, CreateUpdatePizzaDTO dto);
}
