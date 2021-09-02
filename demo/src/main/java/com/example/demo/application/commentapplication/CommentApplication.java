package com.example.demo.application.commentapplication;

import java.util.UUID;

import com.example.demo.DTO.commentDTO.CommentDTO;
import com.example.demo.DTO.commentDTO.CreateCommentDTO;

public interface CommentApplication {
    public CommentDTO add(CreateCommentDTO dto);
    public CommentDTO get(UUID id);
}
