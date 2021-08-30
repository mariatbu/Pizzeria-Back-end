package com.example.demo.application.pizzapplication;

import java.util.UUID;

import com.example.demo.DTO.pizzaDTOs.CreateOrUpdateImageDTO;
import com.example.demo.DTO.pizzaDTOs.ImageDTO;
import com.example.demo.DTO.pizzaDTOs.ImageDTOBytes;
import com.example.demo.core.applicationbase.ApplicationBase;
import com.example.demo.domain.pizzadomain.ImageEntity;
import com.example.demo.domain.pizzadomain.RedisRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public ImageDTO save(CreateOrUpdateImageDTO dto) {
        ImageEntity image = new ImageEntity();
        image.setId(UUID.randomUUID());
        image.setData(dto.getData());

        
        this.redisRepository.add(image);
        // logger.info("Sañadío");
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(image.getId());
        return imageDTO;
    }

    @Override
    public ImageDTOBytes get(UUID id) {
        
        return modelMaper.map(this.findById(id), ImageDTOBytes.class);
    }
}