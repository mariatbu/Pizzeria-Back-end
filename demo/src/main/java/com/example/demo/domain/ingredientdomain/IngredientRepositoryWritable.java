package com.example.demo.domain.ingredientdomain;

import java.util.UUID;

import com.example.demo.core.functionalinterfaces.FindById;
import com.example.demo.core.functionalinterfaces.ExistsByField;


public interface IngredientRepositoryWritable extends FindById<Ingredient, UUID>, ExistsByField {

    public void add(Ingredient ingredient);
    public void update(Ingredient ingredient);
    public void delete(Ingredient ingredient);

}

