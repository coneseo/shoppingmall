package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Beer;

import java.util.List;


public interface BeerService {

    public Beer addBeer(Beer beer, Long categoryId);
    public List<Beer> getBeers(int page, Long categoryId, String searchKind, String searchStr);
}
