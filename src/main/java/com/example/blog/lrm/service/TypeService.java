package com.example.blog.lrm.service;

import com.example.blog.lrm.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author xiangwenhao
 * create 2020/5/17
 */
public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listtype(Pageable pageable);

    Type updateType(Long id,Type type);

    void deleteType(Long id);

    List<Type> listTypeTop(Integer size);
    Type getTypeByName(String name);

    List<Type> listType();
}
