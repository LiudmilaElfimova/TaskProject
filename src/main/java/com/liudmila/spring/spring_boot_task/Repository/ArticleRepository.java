package com.liudmila.spring.spring_boot_task.Repository;

import com.liudmila.spring.spring_boot_task.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
