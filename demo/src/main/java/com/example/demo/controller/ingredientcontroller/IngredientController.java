package com.example.demo.controller.ingredientcontroller;

import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.application.ingredientapplication.IngredientApplication;
import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;

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
@RequestMapping("api/v1/ingredients")
public class IngredientController {
    
    private final IngredientApplication ingredientApplication;

    @Autowired
    public IngredientController(IngredientApplication ingredientApplication){
        this.ingredientApplication = ingredientApplication;
    }

    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody @Valid final CreateUpdateIngredientDTO dto){
        
        IngredientDTO ingredientDTO = this.ingredientApplication.add(dto);
        return ResponseEntity.status(201).body(ingredientDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        IngredientDTO ingredientDTO = this.ingredientApplication.get(id);
        return ResponseEntity.ok(ingredientDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody CreateUpdateIngredientDTO dto) {
        IngredientDTO ingredientDTO = this.ingredientApplication.update(id, dto);
        return ResponseEntity.ok(ingredientDTO);
    }

    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable UUID id){
        this.ingredientApplication.delete(id);
        ResponseEntity.ok("deleted");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.status(200).body(this.ingredientApplication.getAll(name, page, size));
    }

   
}
