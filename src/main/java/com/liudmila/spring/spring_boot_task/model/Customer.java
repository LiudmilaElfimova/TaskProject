package com.liudmila.spring.spring_boot_task.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  id;
    @Column(unique = true, updatable = false)
    private  String сustomerName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
           name = "article_like",
           joinColumns = @JoinColumn(name = "custemer_id"),
           inverseJoinColumns = @JoinColumn(name = "article_id"))
    private Set<Article> likedArticles =new HashSet<>();

    public Customer() { }

    public long getId() {
        return id;
    }

    public String getСustomerName() {
        return сustomerName;
    }

    public void setСustomerName(String сustomername) {
        this.сustomerName = сustomerName;
    }

    public Set<Article> getLikedArticles() {
        return likedArticles;
    }

    public void setLikedArticles(Set<Article> likedArticles) {
        this.likedArticles = likedArticles;
    }
}
