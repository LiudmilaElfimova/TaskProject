package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.Repository.CustomerRepository;
import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * service for working with customer's favorite articles
 *
 * @author Liudmila Elfimova
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private  HackerNewsClient hackerNewsClient;
    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public Customer findCustomerByCustomerName(String customerName) {
        return customerRepository.findCustomerBy–°ustomerName(customerName).orElseThrow();
    }

    /**
     * getting all the customer's favorite articles
     *
     *  @return list of articles
     */
    @Override
    public List<Article> getAllArticleForCustomer(String name) {
        Customer customer= findCustomerByCustomerName(name);
        Set<Article> likedArticles = customer.getLikedArticles();
        List<Article> articles = new ArrayList<>();
        for (Article article : likedArticles) {
            articles.add(hackerNewsClient.getArticle(article.getId()));
        }
        return articles;
    }

    /**
     * saving the customer's favorite article to the Database
     */
    @Override
    public void addFavoriteArticle(String userName,
                                   Integer articleId){
        Customer customer = findCustomerByCustomerName(userName);
        Article article = new Article (articleId);
        article.get–°ustomer().add(customer);
        customer.getLikedArticles().add(article);
        hackerNewsClient.saveArticle(article);
    }
}






