package com.example.demo.domain.userdomain;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryWriter {
    public void add(User user);
    public void update(User user);
    public void delete(User user);
    public Optional<User> findByID(UUID id);
}
