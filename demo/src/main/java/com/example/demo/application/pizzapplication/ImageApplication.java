package com.example.demo.application.pizzapplication;

import com.example.demo.DTO.pizzaDTOs.ImageDTO;
import com.example.demo.DTO.pizzaDTOs.ImageDTOBytes;

import java.util.UUID;

import com.example.demo.DTO.pizzaDTOs.CreateOrUpdateImageDTO;

public interface ImageApplication {
    public ImageDTO save(CreateOrUpdateImageDTO dto);
    // public ImageDTO findById(UUID id);
    public ImageDTOBytes get(UUID id);
    
}