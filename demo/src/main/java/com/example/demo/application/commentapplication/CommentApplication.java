package com.example.demo.application.commentapplication;

import java.util.UUID;

import com.example.demo.dto.commentDTO.CommentDTO;
import com.example.demo.dto.commentDTO.CreateCommentDTO;

public interface CommentApplication {
    public CommentDTO add(CreateCommentDTO dto);
    public CommentDTO get(UUID id);
}
