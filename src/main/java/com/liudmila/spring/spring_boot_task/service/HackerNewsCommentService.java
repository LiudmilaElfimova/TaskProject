package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.model.Article;
import com.liudmila.spring.spring_boot_task.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * getting comments data via API HackerNews
 *
 * @author Liudmila Elfimova
 */
@Service
public class HackerNewsCommentService implements CommentService {
    @Autowired
    private  HackerNewsClient hackerNewsClient;

    /**
     * gets list of oldest comments
     *
     * @return list of comments
     */
    @Override
    public List<Comment> getComments(int id, int  commentId){
        Article article = hackerNewsClient.getArticle(id);
        List<Integer> commentIds = Arrays.asList(article.getKids());
        List<Comment> comments = new ArrayList<>();
        int firstIndex;
        int lastIndex;
        //checking to get the comment id
        lastIndex = commentId == 0 ? commentIds.size() : commentIds.indexOf(commentId);
        firstIndex =   lastIndex<=10 ? 0 : commentIds.size()-10;
        List<Integer> tenCommentIds = commentIds.subList(firstIndex, lastIndex);
        Collections.reverse(tenCommentIds);
        for (int comId : tenCommentIds) {
            Comment comment = hackerNewsClient.getComment(comId);
            comments.add(comment);
        }
        return comments;
    }

}
