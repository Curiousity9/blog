package com.example.blog.lrm.dao;

import com.example.blog.lrm.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

/**
 * @author xiangwenhao
 * create 2020/5/16
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}
