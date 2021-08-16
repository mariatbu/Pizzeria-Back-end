package com.example.demo.domain.commentdomain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Comment {
    @Id
    @Type (type = "uuid-char")
    public UUID id;
    @Column (nullable = false)
    public String text;
    @Column (nullable = false)
    public float rating;
    @Column (nullable = false)
    public String date;
    @Column (nullable = false)
    @Type (type = "uuid-char")
    public UUID user;
    @Column (nullable = false)
    @Type (type = "uuid-char")
    public UUID pizza;
}
