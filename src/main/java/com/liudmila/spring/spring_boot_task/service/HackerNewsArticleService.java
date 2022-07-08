package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class HackerNewsArticleService implements ArticleService {
    @Autowired
    private RestTemplate restTemplate;
    private int id;



    @Override
    public Article getArticle(int id){
        return null;
    }

    @Override
    public List<Article> getArticles(){
        return null;
    }


    @Override
    public List<Integer> getArticleIDs(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Integer>> entity = new HttpEntity<List<Integer>> (headers);

        return restTemplate.exchange(
                "https://hacker-news.firebaseio.com/v0/newstories.json?print=pretty", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Integer>>() {}).getBody();

    }
}
