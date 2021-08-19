package com.example.demo.infrastructure.commentinfraestructure;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.commentdomain.CommentProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentJPARepository extends JpaRepository <Comment, UUID>{
    @Query ("""
    Select c.id as id, c.text as text, 
    c.rating as rating, c.date as date 
    From Comment c Where (:date is NULL OR date LIKE %:date%)""")
    List <CommentProjection> findByCriteria(
        @Param ("date") Date date,
        Pageable pageable
    );
}
