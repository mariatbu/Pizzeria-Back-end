package com.example.demo.controller.pizzacontroller;

import java.io.IOException;

import com.example.demo.application.pizzapplication.ImageApplicationImp;
import com.example.demo.DTO.pizzaDTOs.CreateOrUpdateImageDTO;
import com.example.demo.DTO.pizzaDTOs.ImageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController

@RequestMapping("/redis")

public class ImageController {

    private final ImageApplicationImp imageApplicationImp; 

    @Autowired
    public ImageController(ImageApplicationImp imageApplicationImp) {

        this.imageApplicationImp = imageApplicationImp;

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> upload(@RequestParam("image") MultipartFile file) throws IOException { 

        CreateOrUpdateImageDTO dto = new CreateOrUpdateImageDTO();

        dto.setData(file.getBytes());

        ImageDTO imageDto = imageApplicationImp.save(dto);

        return ResponseEntity.status(201).body(imageDto);

    }
}