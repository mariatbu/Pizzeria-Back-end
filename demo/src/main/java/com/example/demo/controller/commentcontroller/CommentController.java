package com.example.demo.controller.commentcontroller;

import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.application.commentapplication.CommentApplication;
import com.example.demo.DTO.commentDTO.CommentDTO;
import com.example.demo.DTO.commentDTO.CreateCommentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {
    
    private final CommentApplication commentApplication;

    @Autowired
    public CommentController(CommentApplication commmentApplication){
        this.commentApplication = commmentApplication;
    }

    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody @Valid final CreateCommentDTO dto){
        CommentDTO commentDTO = this.commentApplication.add(dto);
        return ResponseEntity.status(201).body(commentDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@Valid @PathVariable UUID id){
        CommentDTO commentDTO = this.commentApplication.get(id);
        return ResponseEntity.ok(commentDTO);
    }
}
