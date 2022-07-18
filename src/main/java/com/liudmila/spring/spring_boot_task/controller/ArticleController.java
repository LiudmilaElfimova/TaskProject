package com.liudmila.spring.spring_boot_task.controller;

import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.model.Customer;
import com.liudmila.spring.spring_boot_task.service.ArticleService;
import com.liudmila.spring.spring_boot_task.service.ReceivingArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    private ReceivingArticleService receivingArticleService;
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
        List<Article> articles= receivingArticleService.getArticles(articleId);
        return articles;
    }

    @PostMapping("/add")
    @ResponseBody
    public void addFavoriteArticle(@RequestParam Map<String,String> reqParam) {
        Customer customer= articleService.findCustomerByCustomerName(reqParam.get("name"));
        Article article= new Article();
        article.setId(Integer.valueOf(reqParam.get("id")));
        article.setTitle(reqParam.get("title"));
        article.setUrl(reqParam.get("url"));
        article.setСustomer(customer);
        articleService.saveArticle(article);
    }
}
