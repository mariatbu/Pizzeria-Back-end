package com.example.demo.infraestructure.pizzainfraestructure;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.pizzadomain.PizzaIngredientProjection;
import com.example.demo.domain.pizzadomain.PizzaProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaRepositoryJPA extends JpaRepository<Pizza, UUID>{
    String sqlExists = """
                        SELECT CASE WHEN COUNT(p)>0 THEN true ELSE false END 
                        FROM Pizza p 
                        WHERE p.name = :name""";

    @Query(sqlExists)
    boolean exists(@Param("name") String name);

    @Query("SELECT p FROM Pizza p WHERE id = :id")
    PizzaIngredientProjection findByPizzaId(
        @Param("id") UUID id
    );

    String sqlGetAll = """
                            SELECT p.id as id, p.name as name, p.price as price 
                            FROM Pizza p 
                            WHERE (:name is NULL OR p.name LIKE %:name%)""";
    @Query(sqlGetAll)
    List<PizzaProjection> findByCriteria(
        @Param("name") String name,
        Pageable pageable
    );
}
