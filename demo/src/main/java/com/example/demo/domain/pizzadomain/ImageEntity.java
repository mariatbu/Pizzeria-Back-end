package com.example.demo.domain.pizzadomain;


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
    
    // @Override
    // public void validate() {
    //     // TODO Auto-generated method stub
    //     super.validate();
    // }
}
