package com.example.demo.DTO.commentDTO;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class CommentDTO {
    public UUID id;
    public String text;
    public BigDecimal rating;
    public UUID user;
    public UUID pizza;
}
