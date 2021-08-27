package com.example.demo.domain.userdomain;


import java.util.UUID;

import com.example.demo.core.functionalinterfaces.ExistsByField;
import com.example.demo.core.functionalinterfaces.FindById;

public interface UserRepositoryWriter extends FindById<User,UUID>, ExistsByField{
    public void add(User user);
    public void update(User user);
    public void delete(User user);
}
