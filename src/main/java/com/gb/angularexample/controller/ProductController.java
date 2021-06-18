package com.gb.angularexample.controller;

import com.gb.angularexample.dto.ProductDto;
import com.gb.angularexample.dto.mappers.ProductDtoMapper;
import com.gb.angularexample.model.Product;
import com.gb.angularexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> findAll(@RequestParam Map<String, String> params,
                                 @RequestParam(name = "page-number", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(name = "page-size", defaultValue = "5") Integer pageSize) {
        return productService.findAll(params, pageNumber, pageSize);
    }

    @PostMapping
    void save(@RequestBody ProductDto product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
