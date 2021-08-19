package com.example.demo.domain.commentdomain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public interface CommentProjection {
    UUID getID();
    String getText();
    BigDecimal getRating();
    Date date();
    UUID user();
    
}
