package com.gb.angularexample.dto.mappers;

import com.gb.angularexample.dto.CategoryDto;
import com.gb.angularexample.dto.ProductDto;
import com.gb.angularexample.model.Category;
import com.gb.angularexample.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CategoryDtoMapper {

    private final ModelMapper mapper;

    public CategoryDto toDto(Category entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CategoryDto.class);
    }
}