package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository {
    @Query("SELECT c from Category c order by  c.ordering ASC")
    public List<Category> getAll();
}
