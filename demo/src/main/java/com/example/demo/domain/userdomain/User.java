package com.example.demo.domain.userdomain;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public @NoArgsConstructor @Getter @Setter class User {
    @Id
    @Type (type = "uuid-char")
    private UUID id;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false, unique = true)
    private String email;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private Rol rol;

}
