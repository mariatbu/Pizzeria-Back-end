package com.example.demo.application.imageapplication;

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


// import org.slf4j.Logger;

@Service
public class ImageApplicationImp extends ApplicationBase<ImageEntity, UUID> implements ImageApplication{

    private final RedisRepository redisRepository;
    private final ModelMapper modelMapper;
    
    // private final Logger logger;

    @Autowired
    public ImageApplicationImp(final ModelMapper modelMapper,
                                final RedisRepository redisRepository){
            super((id) -> redisRepository.get(id));
            this.redisRepository = redisRepository;
            this.modelMapper = modelMapper;
            // this.logger = logger;
    }
    
    @Override
    public ImageDTOId save(CreateOrUpdateImageDTO dto) {
        ImageEntity image =  modelMapper.map(dto, ImageEntity.class);
        image.setId(UUID.randomUUID());
        image.validate();
        ImageDTOId imageDTOId=this.redisRepository.add(image);
        // this.logger.info(serializeObject(image, "added"));
        return imageDTOId;
    }

    @Override
    public ImageDTOBytes get(UUID id) {

        ImageEntity image = this.findById(id);
        ImageDTOBytes imageDTOBytes= this.modelMapper.map(image, ImageDTOBytes.class);
        return imageDTOBytes; 
    }

    
}