package com.example.solchall2024.repository;

import com.example.solchall2024.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
