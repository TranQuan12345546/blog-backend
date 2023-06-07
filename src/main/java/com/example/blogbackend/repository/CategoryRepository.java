package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(nativeQuery = true ,value = "SELECT Category.*, COUNT(blog_category.blog_id) AS blog_count\n" +
            "FROM Category\n" +
            "LEFT JOIN blog_category ON Category.id = blog_category.category_id\n" +
            "GROUP BY Category.id;")
    List<Object[]> findAllWithBlogCount();

    @Query(nativeQuery = true, value = "SELECT Category.id, Category.name, COUNT(blog_category.blog_id) AS blog_count\n" +
            "FROM Category\n" +
            "LEFT JOIN blog_category ON Category.id = blog_category.category_id\n" +
            "GROUP BY Category.id\n" +
            "ORDER BY blog_count DESC\n" +
            "LIMIT 5")
    List<Object[]> findCategoryByTop5BlogNumber();

    @Query("SELECT b FROM Blog b JOIN b.categories c WHERE c.name = :categoryName")
    List<Blog> findBlogsByCategoryName(@Param("categoryName") String categoryName);
}
