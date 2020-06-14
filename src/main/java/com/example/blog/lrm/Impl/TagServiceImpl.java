package com.example.blog.lrm.Impl;

import com.example.blog.NotFoundException;
import com.example.blog.lrm.dao.TagRepository;
import com.example.blog.lrm.po.Tag;
import com.example.blog.lrm.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangwenhao
 * create 2020/5/19
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag tag1 = tagRepository.getOne(id);
        if(tag1 == null)
            throw new NotFoundException("不存在该标签");
        BeanUtils.copyProperties(tag,tag1);
        return tagRepository.save(tag1);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional

    @Override
    public List<Tag> tags() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> tagList(String ids) {//1,2,3
        return tagRepository.findAllById(converTolist(ids));
    }


    @Transactional
    @Override
    public List<Tag> listTagTop(Integer szie) {
        Sort  sort =Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,szie,sort);
        return tagRepository.findTop(pageable);
    }

    public   List<Long> converTolist(String ids){
        List<Long> list= new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idarray=ids.split(",");
            for (int i=0;i<idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
}
