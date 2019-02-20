package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Beer;

import java.util.List;


public interface BeerService {

    public Beer addBeer(Beer beer, Long categoryId);
    public Beer getBeer(Long id);
    public List<Beer> getBeers(int page, Long categoryId, String searchKind, String searchStr);
}
