package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.User;
import com.example.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User join(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
