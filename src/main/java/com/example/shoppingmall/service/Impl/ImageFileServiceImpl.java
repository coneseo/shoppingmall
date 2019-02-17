package com.example.shoppingmall.service.Impl;

import com.example.shoppingmall.domain.ImageFile;
import com.example.shoppingmall.repository.ImageFileRepository;
import com.example.shoppingmall.service.ImageFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService {
    private final ImageFileRepository imageFileRepository;
    @Override
    @Transactional
    public ImageFile getImageFile(Long id) {
        return imageFileRepository.findById(id).get();
    }
}
