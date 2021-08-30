package com.example.demo.domain.imagedomain;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;


@Repository
public interface RedisRepository {

    void add(ImageEntity image);
    Optional<ImageEntity> get(UUID id);
    
}
