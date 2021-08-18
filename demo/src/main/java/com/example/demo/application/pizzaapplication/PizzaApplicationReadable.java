package com.example.demo.application.pizzaapplication;

import java.util.List;

import com.example.demo.domain.pizzadomain.PizzaProjection;
// import com.example.demo.dto.commentdtos.CommentDTO;
// import com.example.demo.dto.commentdtos.CreateCommentDTO;


public interface PizzaApplicationReadable {    

    public List<PizzaProjection> getAll(String name, int page, int size);
}
