package com.example.demo.controller.imagecontroller;


import java.io.IOException;
import java.util.UUID;
import javax.validation.Valid;

import com.example.demo.application.imageapplication.ImageApplication;
import com.example.demo.dto.imageDTO.CreateOrUpdateImageDTO;
import com.example.demo.dto.imageDTO.ImageDTOBytes;
import com.example.demo.dto.imageDTO.ImageDTOId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/redis")
public class ImageController {

    private final ImageApplication imageApplication;
 
    @Autowired
    public ImageController(final ImageApplication imageApplication){
        this.imageApplication = imageApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestParam("image") MultipartFile file) throws IOException {

        CreateOrUpdateImageDTO dto = new CreateOrUpdateImageDTO();
        dto.setData(file.getBytes());

        ImageDTOId imageDTOId = this.imageApplication.save(dto);
        
        return ResponseEntity.status(201).body(imageDTOId);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@Valid @PathVariable UUID id) throws IOException {

        ImageDTOBytes imageDtoBytes = this.imageApplication.get(id);
        return ResponseEntity.status(HttpStatus.OK)
        .body(imageDtoBytes);
    }
}