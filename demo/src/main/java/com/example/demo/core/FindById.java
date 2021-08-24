package com.example.demo.core;

import java.util.Optional;

public interface FindById<T> {

    public <ID> Optional<T> getById(ID id);

}
