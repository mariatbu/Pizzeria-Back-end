package com.example.demo.infraestructure.commentinfraestructure;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.commentdomain.CommentRepositoryWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentRepositoryWriter{
    private final CommentJPARepository commentJPARepository;

    @Autowired
    public CommentRepositoryImpl(final CommentJPARepository commentJPARepository){
        this.commentJPARepository = commentJPARepository;
    }
    @Override
    public void add(Comment comment) {
        this.commentJPARepository.save(comment);      
    }
    @Override
    public Optional<Comment> findById(UUID id) {
        return this.commentJPARepository.findById(id);
    }
    @Override
    public boolean exists(String field) {
        return this.commentJPARepository.exists(field);
    }
}
