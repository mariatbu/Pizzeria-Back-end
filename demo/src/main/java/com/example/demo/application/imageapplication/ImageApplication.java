package com.example.demo.application.imageapplication;

import java.util.UUID;

import com.example.demo.dto.imageDTO.CreateOrUpdateImageDTO;
import com.example.demo.dto.imageDTO.ImageDTOBytes;
import com.example.demo.dto.imageDTO.ImageDTOId;

public interface ImageApplication {
    public ImageDTOId save(CreateOrUpdateImageDTO dto);
    // public ImageDTO findById(UUID id);
    public ImageDTOBytes get(UUID id);
    
}