package com.example.demo.domain.userdomain;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.core.EntityBase;



@Entity
@Table(name = "users")
public @NoArgsConstructor @Getter @Setter class User extends EntityBase{

    @Column(nullable = false)
    @NotBlank 
    private String name;

    @Column(nullable = false)
    @NotBlank  
    private String lastName;

    @Column (unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column (nullable = false)
    @NotNull
    private String password;

    @Column
    @NotNull
    private Rol rol = Rol.ROL_USER;

    @Transient
    private String token;

}
