package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.Repository.ArticleRepository;
import com.liudmila.spring.spring_boot_task.Repository.CustomerRepository;
import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    @Override
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }
}

