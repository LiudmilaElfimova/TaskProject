package com.liudmila.spring.spring_boot_task.controller;

import com.liudmila.spring.spring_boot_task.model.Comment;
import com.liudmila.spring.spring_boot_task.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 *  controller to manage comments
 *
 *  @author Liudmila Elfimova
 */
@RestController
@RequestMapping("/api")

public class CommentController {
    /**
     * data access service via API
     */
    @Autowired
    private CommentService commentService;

    /**
     * endpoint for getting comments
     *
     * @return list of comments
     */

    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> getComments(@RequestParam Integer id,
                                     @RequestParam Optional<Integer> commentId) {
        Integer comId = commentId.orElseGet(() -> 0);
        List <Comment> comments = commentService.getComments(id, comId);
        return comments;
    }
}
