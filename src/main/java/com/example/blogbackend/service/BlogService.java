package com.example.blogbackend.service;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> findAll(Integer page, Integer pageSize) {
        return blogRepository.findAll(PageRequest.of(page, pageSize));
    }

    public List<Blog> findByTitleLike(String term) {
        return blogRepository.findByTitleLike(term);
    }

    public Blog getDetailBlog(int blogId, String blogSlug) {
        return blogRepository.findBlogByIdAndSlug(blogId, blogSlug);
    }
}
