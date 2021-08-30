package com.example.demo.domain.imagedomain;


import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import com.example.demo.core.EntityBase;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@RedisHash("Image")
@Embeddable
public @Getter @Setter @NoArgsConstructor class ImageEntity extends EntityBase {
    
    @Size(min = 1) 
    private byte[] data;

    
    private String cloudId;    
    private String cloudUrl;

    
}
