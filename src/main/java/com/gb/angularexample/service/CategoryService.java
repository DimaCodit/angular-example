package com.gb.angularexample.service;

import com.gb.angularexample.dto.CategoryDto;
import com.gb.angularexample.dto.ProductDto;
import com.gb.angularexample.dto.mappers.CategoryDtoMapper;
import com.gb.angularexample.model.Category;
import com.gb.angularexample.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryDtoMapper mapper;

    public List<CategoryDto> findAll() {
        return repository.findAll(Sort.by("title"))
                .stream()
                .map(category -> mapper.toDto(category))
                .collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        Category category = repository.findById(id).orElseThrow(()->new NoSuchElementException(" "));
        return mapper.toDto(category);
    }

    public Category findById2(Long id) {
        Category category = repository.findById(id).orElseThrow(()->new NoSuchElementException(" "));
        return category;
        //return mapper.toDto(category);
    }
}
