package com.example.demo.domain.pizzadomain;

import java.util.UUID;

import com.example.demo.core.functionalinterfaces.ExistsByField;
import com.example.demo.core.functionalinterfaces.FindById;

public interface PizzaRepositoryWritable extends FindById<Pizza, UUID>, ExistsByField{
    public void add(Pizza pizza);
    public void update(Pizza pizza);
    public void delete(Pizza pizza);
}
