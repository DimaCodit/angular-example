package com.gb.angularexample.dto.mappers;

import com.gb.angularexample.dto.ProductDto;
import com.gb.angularexample.model.Category;
import com.gb.angularexample.model.Product;
import com.gb.angularexample.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductDtoMapper {

    private final ModelMapper mapper;
    private final CategoryRepository categoryRepository;

    public Product toEntity(ProductDto dto) {
       Product product = Objects.isNull(dto) ? null : mapper.map(dto, Product.class);
       if(!Objects.isNull(product)) {
           Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(()->new NoSuchElementException());
           product.setCategory(category);
       }
       return product;
    }

    @PostConstruct
    private void setMaps(){
        mapper.typeMap(Product.class, ProductDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getCategory().getTitle(), ProductDto::setCategoryTitle);
            mapper.map(src -> src.getCategory().getId(), ProductDto::setCategoryId);
        });
    }

    public ProductDto toDto(Product entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ProductDto.class);
    }
}