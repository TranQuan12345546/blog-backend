package com.example.blogbackend.service;

import com.example.blogbackend.dto.CategoryDto;
import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Category;
import com.example.blogbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private List<CategoryDto> castToDto(List<Object[]> categories) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Object[] i : categories) {
            Integer categoryId = (Integer) i[0];
            String categoryName = (String) i[1];
            Long blogCount = (Long) i[2];
            CategoryDto dto = new CategoryDto(categoryId, categoryName, blogCount);
            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    public List<CategoryDto> getAllCategories() {
        List<Object[]> categories = categoryRepository.findAllWithBlogCount();
        List<CategoryDto> categoryDtos = castToDto(categories);
        return categoryDtos;
    }


    public List<CategoryDto> findCategoryByTop5BlogNumber() {
        List<Object[]> categories = categoryRepository.findCategoryByTop5BlogNumber();
        List<CategoryDto> categoryDtos = castToDto(categories);
        return categoryDtos;
    }

    public List<Blog> getBlogByCategoryName(String categoryName) {
        return categoryRepository.findBlogsByCategoryName(categoryName);

    }
}
