package com.example.demo.domain.commentdomain;

import java.util.UUID;

import com.example.demo.core.functionalinterfaces.ExistsByField;
import com.example.demo.core.functionalinterfaces.FindById;

public interface CommentRepositoryWriter extends FindById<Comment,UUID>, ExistsByField{
    public void add(Comment comment);
}
