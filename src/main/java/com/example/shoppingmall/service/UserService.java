package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.User;

public interface UserService {
    public User join(User user);
    public void deleteUser(Long id);
}
