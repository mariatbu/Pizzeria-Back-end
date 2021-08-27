package com.example.demo.infraestructure.imageinfraestructure;

import java.util.UUID;

import com.example.demo.domain.imagedomain.Image;
import com.example.demo.domain.imagedomain.ImageRepositoryRedis;

public class ImageRepositoryRedisImp implements ImageRepositoryRedis {

    @Override
    public Image get(UUID id) {
        //TODO:  A QUÉ ESTÁS ESPERANDO
        return new Image();
    }
    
}
