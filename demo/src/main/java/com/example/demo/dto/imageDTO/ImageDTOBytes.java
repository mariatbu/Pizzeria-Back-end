package com.example.demo.dto.imageDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class ImageDTOBytes extends ImageDTOId {

    private byte[] data;
    
}
