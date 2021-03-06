package com.example.shoppingmall.service.Impl;

import com.example.shoppingmall.domain.Role;
import com.example.shoppingmall.repository.RoleRepository;
import com.example.shoppingmall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Transactional
    @Override
    public void addRole(Role role) {
        Role result = roleRepository.save(role);
        System.out.println(result.getId() + "," + result.getName());
    }
}
