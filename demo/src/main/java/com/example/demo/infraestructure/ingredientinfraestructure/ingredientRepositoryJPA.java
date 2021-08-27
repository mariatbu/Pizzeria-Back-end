package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientRepositoryJPA extends JpaRepository<Ingredient, UUID>{

    Ingredient findByName(@Param("name") String name);
    String sqlSelect = """
                        SELECT i.id as id, i.name as name, i.price as price 
                        FROM Ingredient i 
                        WHERE (:name is NULL OR name LIKE %:name%)""";

    @Query(sqlSelect)
    List<IngredientProjection> findByCriteria(@Param("name") String name, Pageable pageable);

    final String sqlExists = """
                                select case when count(i)> 0 then true else false 
                                end from Ingredient i
                                where i.name = :name""";


    @Query(sqlExists)
    boolean exists(@Param("name") String name);

}