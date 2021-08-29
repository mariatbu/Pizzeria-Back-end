package com.example.demo.domain.userdomain;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.demo.core.EntityBase;



@Entity
@Table(name = "users")
public @NoArgsConstructor @Getter @Setter class User extends EntityBase{

    @Column(nullable = false)
    @NotNull 
    private String name;

    @Column(nullable = false)
    @NotNull 
    private String lastName;

    @Column (unique = true, nullable = false)
    @NotNull @Email
    private String email;

    @Column (nullable = false)
    @NotNull 
    private String password;

    @Column
    @NotNull
    private Rol rol = Rol.ROL_USER;
    

    @Override
    public String toString() {
        return String.format("User {id: %s, name: %s, lastName: %s, email: %s}", 
        this.getId(), this.getName(), this.getLastName(), this.getEmail());
    }
}
