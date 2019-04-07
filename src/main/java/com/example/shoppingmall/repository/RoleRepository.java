package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.name = :name")
    public Role getRoleByName(@Param("name") String name);
}
