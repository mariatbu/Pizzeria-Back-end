package com.example.demo.application.ingredientapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.DTO.ingredientDTO.CreateUpdateIngredientDTO;
import com.example.demo.DTO.ingredientDTO.IngredientDTO;
import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository, final ModelMapper modelMapper){
        super((id)->ingredientRepository.findById(id));
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = new ModelMapper(); //TODO: no instanciar aquí hablar con Juan Carlos
    }

    @Override
    public IngredientDTO add(CreateUpdateIngredientDTO dto) {
        Ingredient  ingredient= this.modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        //TODO: validar que la pizza no existe con un findByName (validar que no está el nombre duplicado)
        //No puedo usar orElseThrow porque va al revés y no quiero devolver null
        ingredient.validate();
        this.ingredientRepository.add(ingredient);
        //log ok
        return this.modelMapper.map(ingredient,IngredientDTO.class);  
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.findById(id);
        IngredientDTO ingredientDTO = this.modelMapper.map(ingredient, IngredientDTO.class);
        return ingredientDTO;
    }

    @Override
    public void update(UUID id, CreateUpdateIngredientDTO dto) {
        Ingredient ingredient =  this.findById(id);
        ingredient.setName(dto.getName());
        ingredient.setPrice(dto.getPrice());
        this.ingredientRepository.update(ingredient);
    }

    @Override
    public void delete(UUID id) {
        // Ingredient ingredient = new Ingredient();
        // ingredient.setId(id);
        Ingredient ingredient = this.findById(id); //PODRÍA ESTAR TIRANDO 2 QUERY
        this.ingredientRepository.delete(ingredient);
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size) {
        return this.ingredientRepository.getAll(name, page, size);
    }
    
}
