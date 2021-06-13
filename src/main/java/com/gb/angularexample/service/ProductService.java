package com.gb.angularexample.service;

import com.gb.angularexample.model.Product;
import com.gb.angularexample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> findAll(Map<String, String> params, Integer pageNumber, Integer pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber-1, pageSize));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
