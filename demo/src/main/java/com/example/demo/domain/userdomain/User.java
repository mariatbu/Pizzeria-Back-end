package com.example.demo.domain.userdomain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class User {
    @Id
    @Type (type = "uuid-char")
    public UUID id;
    @Column (nullable = false)
    public String name;
    @Column (nullable = false)
    public String lastName;
    @Column (nullable = false, unique = true)
    public String email;
    @Column (nullable = false)
    public String password;


}
