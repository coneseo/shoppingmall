package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    @Query(value = "SELECT b FROM Beer b INNER JOIN FETCH b.category ORDER BY b.id DESC",
            countQuery = "SELECT count(b) FROM Beer b"
    )
    public Page<Beer> getBeers(Pageable pageable);
}