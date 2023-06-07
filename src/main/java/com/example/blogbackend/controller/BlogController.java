package com.example.blogbackend.controller;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlog(@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Blog> result = blogService.findAll(page, pageSize);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBlogByName(@RequestParam String term) {
        List<Blog> result = blogService.findByTitleLike(term);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/blogs/{blogId}/{blogSlug}")
    public ResponseEntity<?> getDetailBlog(@PathVariable int blogId, @PathVariable String blogSlug) {
        Blog result = blogService.getDetailBlog(blogId, blogSlug);
        return ResponseEntity.ok(result);
    }
}
