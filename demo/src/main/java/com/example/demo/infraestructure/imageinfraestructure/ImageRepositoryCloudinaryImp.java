package com.example.demo.infraestructure.imageinfraestructure;

import com.example.demo.domain.imagedomain.Image;
import com.example.demo.domain.imagedomain.ImageCloudinary;
import com.example.demo.domain.imagedomain.ImageRepositoryCloudinary;

public class ImageRepositoryCloudinaryImp implements ImageRepositoryCloudinary{
    @Override
    public ImageCloudinary add(Image image){
        return new ImageCloudinary();
    }
}
