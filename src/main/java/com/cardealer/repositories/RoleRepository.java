package com.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cardealer.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    @Query(value = "select * from role where name = ?1", nativeQuery=true)
    public Role findRole(String role);

    @Query(value = "select * from user_roles where user_id = ?1", nativeQuery=true)
    public <List>Role findAllRoles();
}

