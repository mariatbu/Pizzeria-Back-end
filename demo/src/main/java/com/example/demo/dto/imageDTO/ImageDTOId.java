package com.example.demo.dto.imageDTO;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @Getter @Setter @NoArgsConstructor class ImageDTOId {
    
    public UUID id;

    private String cloudId; 
    
    private String cloudUrl;
}
