package com.example.shoppingmall.controller;

import com.example.shoppingmall.domain.Beer;
import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.service.BeerService;
import com.example.shoppingmall.service.BeerServiceImpl;
import com.example.shoppingmall.service.CategoryService;
import com.example.shoppingmall.service.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/beers")
@RequiredArgsConstructor
public class BeerController {
    private final CategoryServiceImpl categoryServiceImpl;
    private final BeerServiceImpl beerServiceImpl;

    @GetMapping("/add")
    public String addform(Model model){
        List<Category> categories = categoryServiceImpl.getAll();
        model.addAttribute("categories", categories);
        return "beers/addform";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "price") long price,
            @RequestParam(name = "amount") long amount,
            @RequestParam(name = "categoryId") long categoryId
    ){
        Beer beer = new Beer();
        beer.setName(name);
        beer.setAmount(amount);
        beer.setPrice(price); //Todo 맥주 추가로직, image파일
    }
}
