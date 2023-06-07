package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository <Blog, Integer> {
    @Query("SELECT b FROM Blog b WHERE b.status = true AND b.publishedAt IS NOT NULL ORDER BY b.publishedAt DESC")
    Page<Blog> findAll(Pageable pageable);
    @Query(nativeQuery = true, value = "select * from blog where blog.status = true AND blog.title like %?1% ")
    List<Blog> findByTitleLike(String name);

    @Query("SELECT b FROM Blog b WHERE b.status = true AND b.id = :id AND b.slug = :slug")
    Blog findBlogByIdAndSlug(@Param("id") int id, @Param("slug") String slug);
}
