package com.example.demo.domain.userdomain;

import java.util.List;


public interface UserRepositoryReader {
    public List<UserProjection> getAll(String name, int page, int size);
}
