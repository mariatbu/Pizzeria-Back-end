package com.example.demo.application.userapplication;

import java.util.List;
import java.util.UUID;


import com.example.demo.domain.userdomain.User;
import com.example.demo.domain.userdomain.UserProjection;
import com.example.demo.dto.userDTO.CreateOrUpdateUserDTO;
import com.example.demo.dto.userDTO.UserDTO;
import com.example.demo.domain.userdomain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserApplicationImpl implements UserApplication {

    private final UserRepository userRepository;
    
    @Autowired
    public UserApplicationImpl(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO add(CreateOrUpdateUserDTO dto) {
        User user = UserService.create(dto);
        this.userRepository.add(user);
        log.info("Usuario: " +user.getName()); 
        return UserService.createDTO(user);
    }

    @Override
    public UserDTO get(UUID id) {
        User user = this.userRepository.findByID(id).orElseThrow();
        return UserService.createDTO(user);
    }

    @Override
    public void update(UUID id, CreateOrUpdateUserDTO dto) {
        User user = this.userRepository.findByID(id).orElseThrow();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        this.userRepository.update(user);
        
    }

    @Override
    public void delete(UUID id) {
        User user = this.userRepository.findByID(id).orElseThrow();
        this.userRepository.delete(user);
        
    }

    @Override
    public List<UserProjection> getAll(String name, int page, int size) {
        return this.userRepository.getAll(name, page, size);
    }
    
}
