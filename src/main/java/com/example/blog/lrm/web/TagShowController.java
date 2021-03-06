package com.example.blog.lrm.web;

import com.example.blog.lrm.po.Tag;
import com.example.blog.lrm.po.Type;
import com.example.blog.lrm.service.BlogService;
import com.example.blog.lrm.service.TagService;
import com.example.blog.lrm.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author xiangwenhao
 * create 2020/5/24
 */
@Controller
public class TagShowController {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;
    @GetMapping("/tags/{id}")
    public String types(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model,
                        @PathVariable Long id){
        List<Tag> tags = tagService.listTagTop(1000);
        if(id == -1){
            id=tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);
        return "tags";
    }
}
