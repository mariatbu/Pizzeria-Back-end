package com.example.demo.application.userapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.userdomain.UserProjection;
import com.example.demo.DTO.userDTO.UserDTO;
import com.example.demo.DTO.userDTO.CreateOrUpdateUserDTO;

public interface UserApplication {
    public UserDTO add(CreateOrUpdateUserDTO dto);

    public UserDTO get(UUID id);

    public UserDTO update(UUID id, CreateOrUpdateUserDTO dto);

    public void delete(UUID id);

    public List<UserProjection> getAll(String email, int page, int size);

    //public UserDTO findByCriteria(String email);
}
