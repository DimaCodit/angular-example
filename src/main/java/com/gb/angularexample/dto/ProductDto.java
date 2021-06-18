package com.gb.angularexample.dto;

import com.gb.angularexample.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    Long id;
    String title;
    Integer price;
    String categoryTitle;
    Long categoryId;
}
