package com.example.demo.core.applicationbase;

import com.example.demo.core.FindById;
import com.example.demo.core.Exceptions.NotFoundException;

public class ApplicationBase<T, ID> {
    private FindById<T> findById;
    public <ID> T findById(ID id){
        T t = this.findById.getById(id).orElseThrow(()->{throw new NotFoundException();});
        return t;
    }
    public ApplicationBase(FindById<T> findById){
        this.findById = findById;
    }
}
