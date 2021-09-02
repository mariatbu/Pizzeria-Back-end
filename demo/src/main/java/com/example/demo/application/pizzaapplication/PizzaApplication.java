package com.example.demo.application.pizzaapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.pizzadomain.PizzaProjection;
import com.example.demo.DTO.pizzaDTO.CreatePizzaDTO;
import com.example.demo.DTO.pizzaDTO.PizzaDTO;
import com.example.demo.DTO.pizzaDTO.UpdatePizzaDTO;

public interface PizzaApplication {
    public PizzaDTO add(CreatePizzaDTO dto);
    public PizzaDTO get(UUID id);
    public PizzaDTO update(UUID id, UpdatePizzaDTO dto);
    public void delete(UUID id);
    public List<PizzaProjection> getAll(String name, int page, int size);
}
