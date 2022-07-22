package com.liudmila.spring.spring_boot_task.controller;

import com.liudmila.spring.spring_boot_task.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
    @PostMapping("/{userName}/likedArticle")
    @ResponseBody
    public ResponseEntity addFavoriteArticle(@PathVariable("userName") String userName,
                                             @RequestBody Integer articleId){
        try {
             customerService.addFavoriteArticle(userName,articleId);
             return ResponseEntity.ok("Article successfully saved");
        }  catch (Exception e) {
             return ResponseEntity.badRequest().body("Failed to add article");
        }
    }

    /**
     * endpoint for getting all the customer's favorite articles
     */
    @GetMapping("/articles")
    @ResponseBody
    public ResponseEntity getAllArticlesForCustomer(@RequestParam String name) {
        try {
            return ResponseEntity.ok(customerService.getAllArticleForCustomer(name));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to get favorite articles");
        }
    }
}
