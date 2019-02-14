package com.example.shoppingmall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beers")
@RequiredArgsConstructor
public class BeerController {
    private final CategoryService categoryService;
}
