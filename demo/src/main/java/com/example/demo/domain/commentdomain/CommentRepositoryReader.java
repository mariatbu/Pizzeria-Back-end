package com.example.demo.domain.commentdomain;

import java.util.Date;
import java.util.List;

public interface CommentRepositoryReader {
    public List<CommentProjection> getAll(Date date, int page, int size);
    
}
