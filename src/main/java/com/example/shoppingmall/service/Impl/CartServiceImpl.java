package com.example.shoppingmall.service.Impl;

import com.example.shoppingmall.domain.Cart;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.repository.UserRepository;
import com.example.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    @Override
    public List<Cart> selectAll() {
        return null;
    }

    @Override
    public void addCart(Cart cart) {

    }

    @Override
    public Cart getCart(Long userId, Long beerId) {
        return null;
    }
}
