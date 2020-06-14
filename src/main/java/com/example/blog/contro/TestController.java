package com.example.blog.contro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiangwenhao
 * create 2020/5/16
 */
@Controller
public class TestController {
        @RequestMapping("/aa")
        public String index( ){
            return "test";
        }


}
