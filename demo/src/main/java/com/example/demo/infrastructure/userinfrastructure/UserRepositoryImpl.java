package com.example.demo.infrastructure.userinfrastructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.userdomain.User;
import com.example.demo.domain.userdomain.UserProjection;
import com.example.demo.domain.userdomain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;




@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJPARepository userJPARepository;

    @Autowired
    public UserRepositoryImpl(final UserJPARepository userJPARepository){
        this.userJPARepository = userJPARepository;
    }
    @Override
    public void add(User user) {
        this.userJPARepository.save(user);      
    }

    @Override
    public void update(User user) {
        this.userJPARepository.save(user);       
    }

    @Override
    public void delete(User user) {
        this.userJPARepository.delete(user);       
    }

    @Override
    public Optional<User> findByID(UUID id) {
        return this.userJPARepository.findById(id);
    }

    @Override
    public List<UserProjection> getAll(String name, int page, int size) {       
        return this.userJPARepository.findByCriteria(
           name,
           PageRequest.of(page, size, Sort.by("name").descending())
       );
    }
}
