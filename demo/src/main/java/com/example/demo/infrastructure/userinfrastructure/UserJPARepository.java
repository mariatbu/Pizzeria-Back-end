package com.example.demo.infrastructure.userinfrastructure;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.userdomain.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJPARepository extends JpaRepository <User, UUID> {
    @Query ("""
    Select u.id as id, u.name as name, 
    u.lastName as lastName, u.email as email 
    From User u Where (:date is NULL OR date LIKE %:date%)""")
    List <UserProjection> findByCriteria(
        @Param ("name") String name,
        Pageable pageable
    );
    
}
