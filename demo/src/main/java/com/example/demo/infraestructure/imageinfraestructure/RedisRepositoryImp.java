package com.example.demo.infraestructure.imageinfraestructure;


import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.core.exceptions.InternalServerErrorEnum;
import com.example.demo.core.exceptions.InternalServerErrorException;
import com.example.demo.domain.imagedomain.ImageEntity;
import com.example.demo.domain.imagedomain.RedisRepository;
import com.example.demo.dto.imageDTO.ImageDTOId;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepositoryImp implements RedisRepository {

    ImageEntity image;
    private final RedisTemplate<String, byte[]> redisTemplate;
    private final ModelMapper modelMapper;

    @Autowired
    public RedisRepositoryImp(final RedisTemplate<String, byte[]> redisTemplate, final ModelMapper modelMapper) {
        this.redisTemplate = redisTemplate;
        this.modelMapper = modelMapper;
    }

    @Override
    public ImageDTOId add(ImageEntity image) {

        try { // String image2 = Base64.getEncoder().encodeToString(image.getData());
            this.redisTemplate.opsForValue().set(image.getId().toString(), image.getData(), Duration.ofDays(1));            
            Cloudinary cloudinary=new Cloudinary();
            cloudinary.uploader().upload(image.getData(), ObjectUtils.asMap("public_id", image.getId().toString()));

        } catch (Exception e) {
            throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
        } finally {

            if (!this.redisTemplate.getConnectionFactory().getConnection().isClosed()) {
                this.redisTemplate.getConnectionFactory().getConnection().close();
            }

        }
        return this.modelMapper.map(image, ImageDTOId.class);
    }

    @Override
    public Optional<ImageEntity> get(UUID id) {

        try {
            byte[] bytes = this.redisTemplate.opsForValue().get(id.toString());

            if (bytes == null) {
                return Optional.of(null);
            }

            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setId(id);
            imageEntity.setData(bytes);

            return Optional.of(imageEntity);
        } catch (Exception e) {
            throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
        } finally {

            if (!this.redisTemplate.getConnectionFactory().getConnection().isClosed()) {
                this.redisTemplate.getConnectionFactory().getConnection().close();
            }

        }

        
    }

}
