package com.example.demo.application.userapplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.userdomain.UserProjection;
import com.example.demo.domain.userdomain.User;
import com.example.demo.dto.userDTO.UserDTO;
import com.example.demo.dto.userDTO.CreateOrUpdateUserDTO;

public interface UserApplication {
    public UserDTO add(CreateOrUpdateUserDTO dto);

    public UserDTO get(UUID id);

    public void update(UUID id, CreateOrUpdateUserDTO dto);

    public void delete(UUID id);

    public List<UserProjection> getAll(String name, int page, int size);

    public User findByName(String name);
}
