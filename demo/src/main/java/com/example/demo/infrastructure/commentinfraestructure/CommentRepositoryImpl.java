package com.example.demo.infrastructure.commentinfraestructure;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.commentdomain.CommentProjection;
import com.example.demo.domain.commentdomain.CommentRepositoryReader;
import com.example.demo.domain.commentdomain.CommentRepositoryWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class CommentRepositoryImpl implements CommentRepositoryReader, CommentRepositoryWriter{
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
    public void update(Comment comment) {
        this.commentJPARepository.save(comment);       
    }

    @Override
    public void delete(Comment comment) {
        this.commentJPARepository.delete(comment);    
    }

    @Override
    public Optional<Comment> findByID(UUID id) {
        return this.commentJPARepository.findById(id);
    }

    @Override
    public List<CommentProjection> getAll(Date date, int page, int size) {   
        return this.commentJPARepository.findByCriteria(
           date,
           PageRequest.of(page, size, Sort.by("date").descending())
       );
    }

}

