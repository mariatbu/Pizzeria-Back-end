package com.example.demo.infraestructure.commentinfraestructure;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.commentdomain.CommentProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentJPARepository extends JpaRepository <Comment, UUID> {
    Comment findByPizza(@Param("name") String name);

    @Query("""
    SELECT c.id as id, c.text as text, c.rating as rating 
    FROM Comment c INNER JOIN Pizza p ON c.pizza = p.id
    WHERE (:name is NULL OR p.name LIKE %:name%) """)
    List<CommentProjection> findByCriteria(@Param("name") String name, Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(u)>0 THEN true ELSE false END FROM Comment c WHERE c.text = :text")
    boolean exists(@Param("text") String text);
    
}
