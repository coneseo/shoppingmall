package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Role;
import com.example.shoppingmall.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface RoleService {

    public void addRole(Role role);

}
