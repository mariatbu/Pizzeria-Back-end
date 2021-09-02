package com.example.demo.application.commentapplication;

import java.util.UUID;

import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.commentdomain.CommentRepositoryWriter;
import com.example.demo.DTO.commentDTO.CommentDTO;
import com.example.demo.DTO.commentDTO.CreateCommentDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class CommentApplicationImpl extends ApplicationBase<Comment,UUID> implements CommentApplication{

    private final CommentRepositoryWriter commentRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;
    
    @Autowired
    public CommentApplicationImpl(final CommentRepositoryWriter commentRepository,
                                final ModelMapper modelMapper,
                                final Logger logger){

        super((id) -> commentRepository.findById(id));
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }

    @Override
    public CommentDTO add(CreateCommentDTO dto) {
        Comment comment = modelMapper.map(dto, Comment.class);
        comment.setId(UUID.randomUUID());
        comment.setPizzaId(dto.getPizza());
        comment.setUserId(dto.getUser());
        comment.validate();
        this.commentRepository.add(comment);
        logger.info(serializeObject(comment, "Comment Created: ")); 
        return this.modelMapper.map(comment, CommentDTO.class);
    }

    @Override
    public CommentDTO get(UUID id) {
        Comment comment = this.findById(id);
        logger.info(serializeObject(comment, "Comment Searched: "));
        return this.modelMapper.map(comment, CommentDTO.class);
    }
    
}
