package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
