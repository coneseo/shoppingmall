package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
}
