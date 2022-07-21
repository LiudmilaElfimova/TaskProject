package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.model.Customer;

import java.util.List;


public interface CustomerService {

    public void saveArticle(Article article);
    public void saveCustomer(Customer customer);
    public Customer findCustomerByCustomerName(String customerName);
    public List<Article> getAllArticleForCustomer(Customer customer);
}
