package com.example.demo.domain.userdomain;


import java.util.UUID;

import com.example.demo.core.functionalInterfaces.ExistsByField;
import com.example.demo.core.functionalInterfaces.FindById;

public interface UserRepositoryWriter extends FindById<User,UUID>, ExistsByField{
    public void add(User user);
    public void update(User user);
    public void delete(User user);
}
