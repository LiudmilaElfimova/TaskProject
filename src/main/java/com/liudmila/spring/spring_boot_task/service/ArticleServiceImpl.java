package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.Repository.ArticleRepository;
import com.liudmila.spring.spring_boot_task.Repository.CustomerRepository;
import com.liudmila.spring.spring_boot_task.model.Article;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private CustomerRepository customerRepository;


    @Override
    public void saveArticle(Article article){
        articleRepository.save(article);
    }
}

