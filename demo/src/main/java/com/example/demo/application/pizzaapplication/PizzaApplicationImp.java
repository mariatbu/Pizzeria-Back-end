package com.example.demo.application.pizzaapplication;

import java.util.UUID;

import com.example.demo.application.ingredientapplication.IngredientApplicationImp;
import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.imagedomain.Image;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.pizzadomain.PizzaRepository;
import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;
import com.example.demo.dto.pizzaDTO.UpdatePizzaDTO;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaApplicationImp extends ApplicationBase<Pizza, UUID> implements PizzaApplication{

    private final PizzaRepository pizzaRepository;
    private final IngredientApplicationImp ingredientApplicationImp;
    private final ModelMapper modelMapper;
    private final Logger log;

    @Autowired
    public PizzaApplicationImp(final PizzaRepository pizzaRepository, 
                               final IngredientApplicationImp ingredientApplicationImp,
                               final ModelMapper modelMapper, 
                               final Logger log){

        super((id)-> pizzaRepository.findById(id));
        this.pizzaRepository = pizzaRepository;
        this.ingredientApplicationImp = ingredientApplicationImp;
        this.modelMapper = modelMapper;
        this.log = log;
    }

    @Override
    public PizzaDTO add(CreatePizzaDTO dto){
        Pizza pizza = this.modelMapper.map(dto, Pizza.class);
        byte[] image = new byte[2];
        image[0]=0;
        image[1]=1;
        Image imagen = new Image();
        imagen.data = image;
        pizza.setImage(imagen);
        pizza.setId(UUID.randomUUID());
        pizza.validate("name", pizza.getName(), (name)-> this.pizzaRepository.exists(name));
        for (UUID id: dto.getIngredients()){
            Ingredient ingredient = this.modelMapper.map(ingredientApplicationImp.get(id), Ingredient.class);
            pizza.addIngredient(ingredient);
        }
        pizza.setPrice(pizza.calculatePrice());
        this.pizzaRepository.add(pizza);
        this.log.info(this.serializeObject(pizza, "added."));
        PizzaDTO pizzaDTO = this.modelMapper.map(pizza, PizzaDTO.class);
        return pizzaDTO;
    }

    @Override
    public PizzaDTO get(UUID id){
        Pizza pizza = this.findById(id);
        return this.modelMapper.map(pizza, PizzaDTO.class);
    }

    @Override
    public PizzaDTO update(UUID id, UpdatePizzaDTO dto) {
        Pizza pizza = this.findById(id);
        pizza.setId(id);
        if (this.pizzaRepository.exists(pizza.getName())) {
            pizza.validate();
        } else {
            pizza.validate("name", pizza.getName(), (name) -> this.pizzaRepository.exists(name));
        }
        pizza.setName(dto.getName());
        this.pizzaRepository.update(pizza);
        this.log.info(serializeObject(pizza, "updated."));

        return this.modelMapper.map(pizza, PizzaDTO.class);
    }
}
