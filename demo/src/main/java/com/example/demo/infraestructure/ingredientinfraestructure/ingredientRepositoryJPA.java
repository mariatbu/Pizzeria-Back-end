package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.UUID;

import com.example.demo.domain.ingredientdomain.Ingredient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientRepositoryJPA extends JpaRepsitoryMine<Ingredient, UUID>{

    final String sqlExists = """
                                    select case when count(i)> 0 then true else false 
                                    end from Ingredient i
                                    where i.name = :name""";


    @Query(sqlExists)
    boolean exists(@Param("name") String name);

}