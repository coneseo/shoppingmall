package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Cart;
import com.example.shoppingmall.dto.CartItem;

import java.util.List;

public interface CartService {
    public List<Cart> selectAll();
    public void addCart(Cart cart);
    public Cart getCart(Long userId, Long beerId);
}
