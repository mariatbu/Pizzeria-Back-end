package com.example.demo.dto.commentDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class CommentDTO {
    public UUID id;
    public String text;
    public BigDecimal rating;
    public Date date;
    public UUID user;
    public UUID pizza;
}
