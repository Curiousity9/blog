package com.example.blog.lrm.service;

import com.example.blog.lrm.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author xiangwenhao
 * create 2020/5/19
 */
public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id,Tag tag);

    void deleteTag(Long id);

    Tag getTagByName(String name);
    List<Tag> tags();//新增文章tag选择
    List<Tag> listTagTop(Integer szie);//首页tag
    List<Tag> tagList(String ids);//tag选了多少
}
