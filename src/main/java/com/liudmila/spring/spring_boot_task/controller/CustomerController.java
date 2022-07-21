package com.liudmila.spring.spring_boot_task.controller;

import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.model.Customer;
import com.liudmila.spring.spring_boot_task.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  controller to manage the customer's favorite articles
 *
 *  @author Liudmila Elfimova
 */
@RestController
@RequestMapping("/api/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * saving the customer's favorite article to the Database
     */
    @PostMapping("/{userName}/likedArticle/{articleId}")
    @ResponseBody
    public void addFavoriteArticle(@PathVariable("userName") String userName,
                                   @PathVariable("articleId") String articleId){
        Customer customer = customerService.findCustomerByCustomerName(userName);
        Article article = new Article (Integer.parseInt(articleId));
        article.getСustomer().add(customer);
        customer.getLikedArticles().add(article);
        customerService.saveArticle(article);
    }

    /**
     * endpoint for getting all the customer's favorite articles
     *
     * @return list of articles
     */
    @GetMapping("/articles")
    @ResponseBody
    public List<Article> getAllArticlesForCustomer(@RequestParam String name) {
        Customer customer= customerService.findCustomerByCustomerName(name);
        return customerService.getAllArticleForCustomer(customer);
    }
}
