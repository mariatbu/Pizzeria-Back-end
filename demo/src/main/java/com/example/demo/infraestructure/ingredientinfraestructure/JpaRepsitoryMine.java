package com.example.demo.infraestructure.ingredientinfraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaRepsitoryMine<T, ID> extends JpaRepository<T, ID> {

    // @Override
    // public default <S extends T> S save(S entity){
    //     //JpaRepository.super.save(entity)

    //     //return JpaRepository.super.save(entity);
    //     return null;
    // }
}
