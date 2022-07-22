package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.Repository.ArticleRepository;
import com.liudmila.spring.spring_boot_task.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * helper service for interacting with HackerNews
 *
 * @author Liudmila Elfimova
 */
@Service
public class HackerNewsClient {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;


    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public Article getArticle(int id){
        return articleService.getArticle(id);
    }
}
