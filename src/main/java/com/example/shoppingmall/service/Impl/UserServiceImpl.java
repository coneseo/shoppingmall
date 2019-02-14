package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Role;
import com.example.shoppingmall.domain.User;
import com.example.shoppingmall.repository.RoleRepository;
import com.example.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> getUserAll(){
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User join(User user) {
        Role role = roleRepository.getRoleByName("USER");
        user.addRole(role);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
