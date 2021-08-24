package com.example.demo.domain.commentdomain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.core.EntityBase;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public @NoArgsConstructor @Getter @Setter class Comment extends EntityBase{
    

    @Column 
    @NotBlank
    public String text;

    @Column 
    @NotNull
    public BigDecimal rating;

    @Column
    @NotNull
    public Date date;

    @Column 
    @Type (type = "uuid-char")
    public UUID user;

    @Column
    @NotNull
    @Type (type = "uuid-char")
    public UUID pizza;
}
