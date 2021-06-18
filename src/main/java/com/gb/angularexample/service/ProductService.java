package com.gb.angularexample.service;

import com.gb.angularexample.dto.ProductDto;
import com.gb.angularexample.dto.mappers.ProductDtoMapper;
import com.gb.angularexample.model.Product;
import com.gb.angularexample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoMapper mapper;

    public Page<ProductDto> findAll(Map<String, String> params, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize, Sort.by("category").descending());
        Page<Product> productsPage = productRepository.findAll(pageable);
        return new PageImpl<ProductDto>(
                productsPage.stream().map(product -> mapper.toDto(product)).collect(Collectors.toList()),
                pageable,
                productsPage.getTotalElements());
    }

    public Product save(ProductDto product) {
        return productRepository.save(mapper.toEntity(product));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
