package com.example.blogbackend.controller;

import com.example.blogbackend.dto.CategoryDto;
import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Category;
import com.example.blogbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        List<CategoryDto> result = categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/category/top5")
    public ResponseEntity<?> findCategoryByTop5BlogNumber() {
        List<CategoryDto> result = categoryService.findCategoryByTop5BlogNumber();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getBlogByCategoryName(@RequestParam String categoryName) {
        List<Blog> result = categoryService.getBlogByCategoryName(categoryName);
        return ResponseEntity.ok(result);
    }
}
