package com.example.shoppingmall.controller.api;

import com.example.shoppingmall.dto.CartItem;
import com.example.shoppingmall.service.BeerService;
import com.example.shoppingmall.service.CartService;
import com.example.shoppingmall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartApiController {
    private final CartService cartService;
    private final UserService userService;
    private final BeerService beerService;

    @PostMapping
    public String addCartBeer(@RequestBody CartItem cartItem, Principal principal, HttpSession session){
        if(principal == null){
            if(session.getAttribute("cart") == null){
                Map<Long, Integer> cart = new HashMap<>();
                cart.put(cartItem.getBeerId(), cartItem.getQuantity());
                session.setAttribute("cart", cart);
            }else{
                Map<Long, Integer> cart = (Map) session.getAttribute("cart");

                if(cart.containsKey(cartItem.getBeerId())){
                    int quantity  = cart.get(cartItem.getBeerId());
                    quantity += cartItem.getQuantity();
                    cart.put(cartItem.getBeerId(), quantity);
                    session.setAttribute("cart", cart);
                }
            }
        }

        return null;
    }
}
