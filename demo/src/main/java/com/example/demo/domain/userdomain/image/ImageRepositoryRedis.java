package com.example.demo.domain.userdomain.image;

import java.util.UUID;

public interface ImageRepositoryRedis {
    public Image get(UUID id);
}
