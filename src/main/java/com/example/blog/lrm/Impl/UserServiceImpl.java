package com.example.blog.lrm.Impl;

import com.example.blog.lrm.dao.UserRepository;
import com.example.blog.lrm.po.User;
import com.example.blog.lrm.service.UserService;
import com.example.blog.lrm.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiangwenhao
 * create 2020/5/16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
