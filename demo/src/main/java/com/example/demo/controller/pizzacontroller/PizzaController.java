package com.example.demo.controller.pizzacontroller;

import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.application.pizzaapplication.PizzaApplication;
import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;
import com.example.demo.dto.pizzaDTO.UpdatePizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pizzas")
public class PizzaController {

    private final PizzaApplication pizzaApplication;

    @Autowired
    public PizzaController(final PizzaApplication pizzaApplication){
        this.pizzaApplication = pizzaApplication;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody @Valid final CreatePizzaDTO dto){
        PizzaDTO pizzaDTO = this.pizzaApplication.add(dto);
        return ResponseEntity.status(201).body(pizzaDTO);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        PizzaDTO pizzaDTO = this.pizzaApplication.get(id);
        return ResponseEntity.ok(pizzaDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody UpdatePizzaDTO dto) {
        PizzaDTO pizzaDTO = this.pizzaApplication.update(id, dto);
        return ResponseEntity.ok(pizzaDTO);
    }

    @DeleteMapping(path="{/id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        this.pizzaApplication.delete(id);
        return ResponseEntity.status(204).body("");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.status(200).body(this.pizzaApplication.getAll(name, page, size));
    }
}
