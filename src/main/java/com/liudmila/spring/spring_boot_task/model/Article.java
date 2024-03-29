package com.liudmila.spring.spring_boot_task.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    private  String by;
    private  Integer descendants;
    @Id
    private  Integer  id;
    private Integer []  kids;
    private  Integer  score;
    private  Integer  time;
    @Column
    private  String title;
    private  String type;
    @Column
    private  String  url;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "likedArticles")
    private Set<Customer> сustomer=new HashSet<>();

    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }

    public Article() {
    }

    public Article(String by, Integer descendants, Integer id, Integer[] kids, Integer score, Integer time, String title, String type, String url, LocalDateTime createdDate) {
        this.by = by;
        this.descendants = descendants;
        this.id = id;
        this.kids = kids;
        this.score = score;
        this.time = time;
        this.title = title;
        this.type = type;
        this.url = url;
        this.createdDate = createdDate;
    }

    public Article(String by, Integer descendants, Integer id, Integer[] kids, Integer score, Integer time, String title, String type, String url) {
        this.by = by;
        this.descendants = descendants;
        this.id = id;
        this.kids = kids;
        this.score = score;
        this.time = time;
        this.title = title;
        this.type = type;
        this.url = url;
    }


    public Article(Integer id){
        this.id = id;
    }

    public void setСustomer(Set<Customer> сustomer) {
        this.сustomer = сustomer;
    }

    public Set<Customer> getСustomer() {
        return сustomer;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getDescendants() {
        return descendants;
    }

    public void setDescendants(Integer descendants) {
        this.descendants = descendants;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer[] getKids() {
        return kids;
    }

    public void setKids(Integer[] kids) {
        this.kids = kids;
    }

    public int getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}