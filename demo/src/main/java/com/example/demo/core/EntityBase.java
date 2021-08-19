package com.example.demo.core;

import java.util.UUID;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@MappedSuperclass
public @Getter  @Setter @NoArgsConstructor abstract class EntityBase {
    
    @Id
    private UUID id;

    public void validate(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator= factory.getValidator();
        Set<ConstraintViolation<EntityBase>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
        throw new ConstraintViolationException(violations);}
    }

    @Override
    public boolean equals(Object obj)    {
        if (!(obj instanceof EntityBase)) {
            return false;
        }
        EntityBase tmp = (EntityBase)obj;
        return tmp.id.equals(this.id);
    }
   
    @Override
    public int hashCode() {
        return this.id.toString().hashCode();
    }
}
