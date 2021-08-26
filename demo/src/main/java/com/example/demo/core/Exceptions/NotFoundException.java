package com.example.demo.core.Exceptions;

public class NotFoundException extends HttpException{

    public NotFoundException(){
        this("Not found exception");
    }
    public NotFoundException(String message){
        super(404, message);
    }
    
}
