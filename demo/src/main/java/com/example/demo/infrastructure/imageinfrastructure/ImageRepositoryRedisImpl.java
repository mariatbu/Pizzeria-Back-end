package com.example.demo.infrastructure.imageinfrastructure;

import java.util.UUID;

import com.example.demo.domain.userdomain.image.Image;
import com.example.demo.domain.userdomain.image.ImageRepositoryRedis;

public class ImageRepositoryRedisImpl implements ImageRepositoryRedis{
    @Override
    public Image get(UUID id) {
        //TODO: A que estas esperando
        Image image = new Image();
        return image;
        
    }
}
