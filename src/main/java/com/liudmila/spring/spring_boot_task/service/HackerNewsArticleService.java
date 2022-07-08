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
    private final String URL="https://hacker-news.firebaseio.com/v0";


    @Override
    public Article getArticle(int id){
        return restTemplate.getForObject(URL+"/item/"+id+".json?print=pretty", Article.class);
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
                URL+"/newstories.json?print=pretty", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Integer>>() {}).getBody();
    }
}
