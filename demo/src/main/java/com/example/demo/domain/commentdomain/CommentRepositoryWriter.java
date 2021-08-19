package com.example.demo.domain.commentdomain;

import java.util.Optional;
import java.util.UUID;

public interface CommentRepositoryWriter {
    public void add(Comment comment);
    public void update(Comment comment);
    public void delete(Comment comment);
    public Optional<Comment> findByID(UUID id);
}
