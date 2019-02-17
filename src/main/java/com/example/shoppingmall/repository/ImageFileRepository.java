package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {

}
