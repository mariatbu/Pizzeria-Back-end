package com.example.demo.application.imageapplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.imagedomain.ImageEntity;
import com.example.demo.domain.imagedomain.RedisRepository;
import com.example.demo.dto.imageDTO.CreateOrUpdateImageDTO;
import com.example.demo.dto.imageDTO.ImageDTOBytes;
import com.example.demo.dto.imageDTO.ImageDTOId;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


// import org.slf4j.Logger;

@Service
public class ImageApplicationImp extends ApplicationBase<ImageEntity, UUID> implements ImageApplication{

    private final RedisRepository redisRepository;
    private final ModelMapper modelMaper;
    
    // private final Logger logger;

    @Autowired
    public ImageApplicationImp(final ModelMapper modelMaper,
                                final RedisRepository redisRepository){
            super((id) -> redisRepository.get(id));
            this.redisRepository = redisRepository;
            this.modelMaper = modelMaper;
            // this.logger = logger;
    }
    
    @Override
    public ImageDTOId save(CreateOrUpdateImageDTO dto) {
        ImageEntity image = new ImageEntity();
        image.setId(UUID.randomUUID());
        image.setData(dto.getData());

        
        this.redisRepository.add(image);
        // logger.info("Sañadío");
        ImageDTOId imageDTO = new ImageDTOId();
        imageDTO.setId(image.getId());
        return imageDTO;
    }

    @Override
    public ImageDTOBytes get(UUID id) {
        
        return modelMaper.map(this.findById(id), ImageDTOBytes.class);
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}