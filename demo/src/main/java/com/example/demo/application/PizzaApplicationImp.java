package com.example.demo.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.example.demo.domain.commentdomain.Comment;
// import com.example.demo.domain.commentdomain.CommentService;
import com.example.demo.domain.ingredientdomain.Ingredient;
// import com.example.demo.domain.ingredientdomain.IngredientRepository;
import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.pizzadomain.PizzaIngredientProjection;
import com.example.demo.domain.pizzadomain.PizzaProjection;
import com.example.demo.domain.pizzadomain.PizzaRepositoryReadable;
import com.example.demo.domain.pizzadomain.PizzaRepositoryWritable;
import com.example.demo.domain.pizzadomain.PizzaService;
// import com.example.demo.dto.commentdtos.CommentDTO;
// import com.example.demo.dto.commentdtos.CreateCommentDTO;
import com.example.demo.dto.pizzadtos.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PizzaApplicationImp implements PizzaApplication {
           
    private final PizzaRepository pizzaRepository;
    // private final IngredientRepository ingredientRepository;

    


    

    
}
