package com.example.demo.dto.commentDTO;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
public @Getter @Setter @NoArgsConstructor class CreateCommentDTO {
    public String text;
    public BigDecimal rating;
    public UUID user;
    public UUID pizza;
}
