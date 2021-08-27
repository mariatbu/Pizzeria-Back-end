package com.example.demo.domain.userdomain;

import java.util.UUID;

public interface UserProjection {
    UUID getId();

    String getName();

    String getLastName();

    String getEmail();

    
}
