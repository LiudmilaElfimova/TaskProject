package com.liudmila.spring.spring_boot_task.service;

import com.liudmila.spring.spring_boot_task.model.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getComments(int id, int  commentId);
}
