package com.example.demo.infrastructure.imageinfrastructure;

import com.example.demo.domain.userdomain.image.Image;
import com.example.demo.domain.userdomain.image.ImageRepositoryAlgolia;
import com.example.demo.domain.userdomain.image.ImageAlgolia;

public class ImageRepositoryAlgoliaImpl implements ImageRepositoryAlgolia {
    @Override
    public ImageAlgolia add(Image image) {
        return new ImageAlgolia();
    }
}
