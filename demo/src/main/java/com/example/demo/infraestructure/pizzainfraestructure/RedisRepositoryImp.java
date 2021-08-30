package com.example.demo.infraestructure.pizzainfraestructure;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.core.Exceptions.InternalServerErrorEnum;
import com.example.demo.core.Exceptions.InternalServerErrorException;
import com.example.demo.domain.pizzadomain.ImageEntity;
import com.example.demo.domain.pizzadomain.RedisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepositoryImp implements RedisRepository {

    private final RedisTemplate<String, byte[]> redisTemplate;

    @Autowired
    public RedisRepositoryImp(final RedisTemplate<String, byte[]> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void add(ImageEntity image) {

        try { // String image2 = Base64.getEncoder().encodeToString(image.getData());
            this.redisTemplate.opsForValue().set(image.getId().toString(), image.getData(), Duration.ofDays(1));

        } catch (Exception e) {
            throw new InternalServerErrorException(InternalServerErrorEnum.REDIRECT);
        } finally {

            if (!this.redisTemplate.getConnectionFactory().getConnection().isClosed()) {
                this.redisTemplate.getConnectionFactory().getConnection().close();
            }

        }
        // TODO: Cerrar conexion try catch

        // this.redisTemplate.expire(image.getId(), 5, TimeUnit.MINUTES);
        // this.redisTemplate.opsForValue().set("1", "2");

        // String image2 = Base64.getEncoder().encodeToString(image.getData());
        // JedisPool pool = new JedisPool("localhost", 6379);
        // Jedis jedis = pool.getResource();
        // jedis.set("1", "2");
        // String key = image.getId().toString();
        // BoundValueOperations<String, String> boundValueOperations =
        // this.redisTemplate.boundValueOps(key);
        // boundValueOperations.set(image2);

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

        // TODO try catch exception not found devolver oOtional<ImageEntity>
    }
}
