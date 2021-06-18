package com.gb.angularexample.repository;

import com.gb.angularexample.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
