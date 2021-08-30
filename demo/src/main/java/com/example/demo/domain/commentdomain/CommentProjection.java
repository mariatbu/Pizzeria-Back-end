package com.example.demo.domain.commentdomain;

import java.util.UUID;

public interface CommentProjection {
    UUID getId();

    String getText();

    String getRating();
    
}
