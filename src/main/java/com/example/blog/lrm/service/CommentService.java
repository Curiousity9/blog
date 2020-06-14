package com.example.blog.lrm.service;

import com.example.blog.lrm.po.Comment;

import java.util.List;

/**
 * @author xiangwenhao
 * create 2020/5/23
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long BlogId);

    Comment saveComment(Comment comment);
}
