package com.example.blog.lrm.dao;

import com.example.blog.lrm.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author xiangwenhao
 * create 2020/5/19
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select tag from Tag tag")
    List<Tag> findTop(Pageable pageable);
}
