package com.example.demo.DTO.pizzaDTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class ImageDTOBytes extends ImageDTO {

    private byte[] data;
    
}
