package com.example.blog.lrm.service;

import com.example.blog.lrm.po.Blog;
import com.example.blog.lrm.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author xiangwenhao
 * create 2020/5/21
 */
public interface BlogService {
    Blog getBlog(Long id);
    Blog getAndConvert(Long id);//显是blog
    Page<Blog> listBlog(Pageable pageable,BlogQuery blog);//管理查询
    Page<Blog> listBlog(Pageable pageable);//管理界面显示
    Page<Blog> listBlog(Pageable pageable,String query);//搜索按钮实现


    Page<Blog> listBlog(Long id,Pageable pageable  );//tag首页

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    List<Blog> listRecommendBlogTop(Integer size);//首页推荐

    void deleteBlog(Long id);

    Long countBlog();
    Map<String , List<Blog>> archiveBlog();//归档
}
