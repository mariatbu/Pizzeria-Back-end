package com.example.demo.controller.ingredientcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.ingredientapplication.IngredientApplication;
import com.example.demo.DTO.ingredientDTO.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/ingredients")
public class IngredientController {
    
    private final IngredientApplication ingredientApplication;

    @Autowired
    public IngredientController(IngredientApplication ingredientApplication){
        this.ingredientApplication = ingredientApplication;
    }

    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody final CreateUpdateIngredientDTO dto){
        IngredientDTO ingredientDTO = this.ingredientApplication.add(dto);
        return ResponseEntity.status(201).body(ingredientDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        IngredientDTO ingredientDTO = this.ingredientApplication.get(id);
        return ResponseEntity.ok(ingredientDTO);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable UUID id) {
        this.ingredientApplication.delete(id);
    }
}
