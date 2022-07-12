package com.liudmila.spring.spring_boot_task.controller;

import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  controller to manage articles
 *
 *  @author Liudmila Elfimova
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

    /**
     * data access service via API
     */
    @Autowired
    private ArticleService articleService;

    /**
     * endpoint for getting articles
     *
     * @return list of articles
     */
    @GetMapping ("/articles")
    public List<Article> getArticles() {
        List<Article> articles=articleService.getArticles();
        return articles;
    }

    /**
     * endpoint for getting more articles
     *
     * @return list of articles
     */
    @GetMapping ("/more")
    public List<Article> getMoreArticles() {
        List<Article> articles=articleService.getMoreArticles();
        return articles;
    }
}
