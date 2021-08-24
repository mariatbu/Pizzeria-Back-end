package com.example.demo.application.userapplication;

import java.util.List;
import java.util.UUID;


import com.example.demo.domain.userdomain.User;
import com.example.demo.domain.userdomain.UserProjection;
import com.example.demo.dto.userDTO.CreateOrUpdateUserDTO;
import com.example.demo.dto.userDTO.UserDTO;
import com.example.demo.domain.userdomain.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserApplicationImpl implements UserApplication {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    
    @Autowired
    public UserApplicationImpl(final UserRepository userRepository){
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public UserDTO add(CreateOrUpdateUserDTO dto) {
        User user = this.modelMapper.map(dto, User.class);
        user.setId(UUID.randomUUID());
        user.validate();
        this.userRepository.add(user);
        log.info("Creado usuario: " +user.getName()); 
        UserDTO userDTO = this.modelMapper.map(user,UserDTO.class);
        //devolver JWT
        return userDTO;
    }

    @Override
    public UserDTO get(UUID id) {
        User user = this.userRepository.findByID(id).orElseThrow();
        System.out.println(user.getPassword());
        /* if(BCrypt.checkpw("1234",user.getPassword())){
            System.out.println("contraseña correcta");
        } */
        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void update(UUID id, CreateOrUpdateUserDTO dto) {
        User user = this.userRepository.findByID(id).orElseThrow();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
        this.userRepository.update(user);
        log.info("Actualizado usuario: " +user.getName()); 
        
    }

    @Override
    public void delete(UUID id) {
        User user = this.userRepository.findByID(id).orElseThrow();
        this.userRepository.delete(user);
        log.info("Borrado usuario: " +user.getName()); 
        
    }

    @Override
    public List<UserProjection> getAll(String name, int page, int size) {
        return this.userRepository.getAll(name, page, size);
    }
    
    
}
