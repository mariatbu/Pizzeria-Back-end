package com.example.demo.domain.userdomain;

import java.util.UUID;

public interface UserProjection {
    UUID getID();

    String getName();

    String getLastName();

    String getEmail();
}
