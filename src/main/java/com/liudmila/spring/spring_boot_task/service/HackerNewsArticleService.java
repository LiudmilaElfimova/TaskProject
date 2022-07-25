package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * getting articles data via API HackerNews
 *
 * @author Liudmila Elfimova
 */
@Service
public class HackerNewsArticleService implements ArticleService {
    @Autowired
    private  HackerNewsClient hackerNewsClient;

    /**
     * gets list of articles
     *
     * @return list of articles
     */
    @Override
    public List<Article> getArticles(int articleId){
        List<Article> articles = new ArrayList<>();
        int firstIndex;
        int lastIndex;
        List<Integer> articleIds = hackerNewsClient.getArticleIDs();
        //checking to get the article id
        firstIndex = articleId == 0 ? articleId : articleIds.indexOf(articleId) + 1;
        lastIndex = firstIndex + 10;
        List<Integer> tenArticleIds = articleIds.subList(firstIndex, lastIndex);
            for (int id : tenArticleIds) {
                Article article = hackerNewsClient.getArticle(id);
                articles.add(article);
            }
        return articles;
    }
}
