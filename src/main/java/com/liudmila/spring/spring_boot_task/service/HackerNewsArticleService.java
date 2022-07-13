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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * getting articles data via API HackerNews
 *
 * @author Liudmila Elfimova
 */
@Service
public class HackerNewsArticleService implements ArticleService {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL="https://hacker-news.firebaseio.com/v0";
    private List<Article> articles = new ArrayList<>();
    private int firstIndex;
    private int lastIndex;


    /**
     * gets article by id
     *
     * @param id article unique ID
     * @return Article
     */
    @Override
    public Article getArticle(int id){
        return restTemplate.getForObject(URL+"/item/"+id+".json?print=pretty", Article.class);
    }

    /**
     * gets list of article IDs
     *
     * @return list of article IDs
     */
    @Override
    public List<Integer> getArticleIDs(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Integer>> entity = new HttpEntity<List<Integer>> (headers);

        return restTemplate.exchange(
                URL+"/newstories.json?print=pretty", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Integer>>() {}).getBody();
    }

    /**
     * gets list of articles
     *
     * @return list of articles
     */
    @Override
    public List<Article> getArticles(int articleId){
        if ((articleId == 0) && (!articles.isEmpty())) {
            articles.clear();
        }
        List<Integer> articleIds = getArticleIDs();
        //checking to get the article id
        firstIndex = articleId == 0 ? articleId : articleIds.indexOf(articleId) + 1;
        lastIndex = firstIndex + 10;
        List<Integer> tenArticleIds = articleIds.subList(firstIndex, lastIndex);
            for (int id : tenArticleIds) {
                Article article = getArticle(id);
                articles.add(article);
            }
        return articles;
    }
}
