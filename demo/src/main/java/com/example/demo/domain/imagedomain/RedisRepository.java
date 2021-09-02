package com.example.demo.domain.imagedomain;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.dto.imageDTO.ImageDTOId;

import org.springframework.stereotype.Repository;


@Repository
public interface RedisRepository {

    ImageDTOId add(ImageEntity image);
    Optional<ImageEntity> get(UUID id);
    
}
