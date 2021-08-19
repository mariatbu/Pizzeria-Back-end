package com.example.demo.application.commentapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.commentdomain.CommentProjection;
import com.example.demo.dto.commentDTO.CommentDTO;
import com.example.demo.dto.commentDTO.CreateOrUpdateCommentDTO;

public interface CommentApplication {
    public CommentDTO add(CreateOrUpdateCommentDTO dto);

    public CommentDTO get(UUID id);

    public void update (UUID id, CreateOrUpdateCommentDTO dto);

    public void delete(UUID id);

    public List<CommentProjection> getAll(String name, int page, int size);
}
