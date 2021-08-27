package com.example.demo.application.userapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.core.ApplicationBase;
import com.example.demo.domain.userdomain.User;
import com.example.demo.domain.userdomain.UserProjection;
import com.example.demo.dto.userDTO.CreateOrUpdateUserDTO;
import com.example.demo.dto.userDTO.UserDTO;
import com.example.demo.domain.userdomain.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserApplicationImpl extends ApplicationBase<User,UUID> implements UserApplication {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;
    
    @Autowired
    public UserApplicationImpl(final UserRepository userRepository,
                                final ModelMapper modelMapper,
                                final Logger logger){

        super((id) -> userRepository.findById(id));
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }

    @Override
    public UserDTO add(CreateOrUpdateUserDTO dto) {
        User user = modelMapper.map(dto, User.class);
        user.setId(UUID.randomUUID());
        user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
        user.validate("email", user.getEmail(), (email)-> this.userRepository.exists(email));
        this.userRepository.add(user);
        logger.info("User created: " +user.getName()); 
        return this.modelMapper.map(user,UserDTO.class);
        
    }

    @Override
    public UserDTO get(UUID id) {
        User user = this.findById(id);
        return this.modelMapper.map(user, UserDTO.class);
    }


    @Override
    public UserDTO update(UUID id, CreateOrUpdateUserDTO dto) {
        User user = this.findById(id);
        User userUpdated = this.modelMapper.map(dto, User.class);
        userUpdated.setId(user.getId());
        userUpdated.setRol(user.getRol());

        if(BCrypt.checkpw(dto.getPassword(), user.getPassword())){
            userUpdated.setPassword(user.getPassword());
        }else{
            BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
        }
        if(user.getEmail().equals(dto.getEmail())){
            user.validate();
        }else{
            user.validate("email", user.getEmail(), (email)-> this.userRepository.exists(email));
        }
        
 
        this.userRepository.update(userUpdated);
        logger.info("User Updated: " +user.getName());
        return modelMapper.map(userUpdated, UserDTO.class);
        
    }

    @Override
    public void delete(UUID id) {
        User user = this.findById(id);
        this.userRepository.delete(user);
        logger.info("User Deleted: ".concat(user.getName())); 
        
    }

    @Override
    public List<UserProjection> getAll(String email, int page, int size) {
        return this.userRepository.getAll(email, page, size);
    }

    
    
    
}
