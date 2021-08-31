package com.example.demo.application.pizzaapplication;

import java.util.UUID;

import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;
import com.example.demo.dto.pizzaDTO.UpdatePizzaDTO;

public interface PizzaApplication {
    public PizzaDTO add(CreatePizzaDTO dto);
    public PizzaDTO get(UUID id);
    public PizzaDTO update(UUID id, UpdatePizzaDTO dto);
}
