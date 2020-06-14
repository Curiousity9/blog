package com.example.blog.lrm.service;

import com.example.blog.lrm.po.User;

/**
 * @author xiangwenhao
 * create 2020/5/16
 */
public interface UserService {
    User checkUser(String username,String password);
}
