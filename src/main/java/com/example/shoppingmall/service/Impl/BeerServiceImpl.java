package com.example.shoppingmall.service.Impl;

import com.example.shoppingmall.domain.Beer;
import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.domain.User;
import com.example.shoppingmall.repository.BeerRepository;
import com.example.shoppingmall.repository.CategoryRepository;
import com.example.shoppingmall.repository.UserRepository;
import com.example.shoppingmall.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Beer addBeer(Beer beer, Long categoryId) {
        Optional<Category> optionalCategory
                = categoryRepository.findById(categoryId);
        beer.setCategory(optionalCategory.get());

        return beerRepository.save(beer);
    }

    @Override
    @Transactional
    public Beer getBeer(Long id) {

        return beerRepository.getBeerById(id);
    }

    @Override
    public List<Beer> getBeers(int page, Long categoryId, String searchKind, String searchStr) {
        int limit = 5;
        int start = page * limit - limit;
        return beerRepository.getBeers(categoryId, start, limit, searchKind, searchStr);
    }
}
