package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.model.Article;

import java.util.List;
public interface ReceivingArticleService {

    public Article getArticle(int id);
    public List <Article> getArticles(int articleId);
    public List<Integer> getArticleIDs();




}
