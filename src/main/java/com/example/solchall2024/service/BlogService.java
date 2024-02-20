package com.example.solchall2024.service;

import com.example.solchall2024.domain.Article;
import com.example.solchall2024.dto.AddArticleRequest;
import com.example.solchall2024.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
