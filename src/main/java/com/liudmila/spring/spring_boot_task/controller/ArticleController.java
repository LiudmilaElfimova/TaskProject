package com.liudmila.spring.spring_boot_task.controller;

import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

@GetMapping ("/articles")
    public List<Article> getArticles() {
        List<Article> articles=articleService.getArticles();
        return articles;
    }

    /*
    @GetMapping ("/test")
    public Integer myTest() {
        List<Integer> articleIds = articleService.getArticleIDs();
        return articleIds.get(0);
    }

    @GetMapping ("/test2")
    public Article myTest2() {
        Article article = articleService.getArticle(articleService.getArticleIDs().get(1));
        return article;
    }
     */

}