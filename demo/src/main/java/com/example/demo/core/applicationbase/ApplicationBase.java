package com.example.demo.core.applicationbase;

import com.example.demo.core.FindById;
import com.example.demo.core.Exceptions.NotFoundException;

public abstract class ApplicationBase<T, ID> {
    private FindById<T, ID> findById;
    protected T findById(ID id){
        T t = this.findById.findById(id).orElseThrow(()->{throw new NotFoundException();});
        return t;
    }
    protected ApplicationBase(FindById<T, ID> findById){
        this.findById = findById;
    }
}
