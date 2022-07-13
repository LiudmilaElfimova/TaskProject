package com.liudmila.spring.spring_boot_task.controller;

import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @ResponseBody
    public List<Article> getArticles(@RequestParam Optional<Integer> id) {
        Integer articleId = id.orElseGet(() -> 0);
        List<Article> articles=articleService.getArticles(articleId);
        return articles;
    }
}
