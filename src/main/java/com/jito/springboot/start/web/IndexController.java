package com.jito.springboot.start.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        // 머스테치 스타터 덕분에 src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리하게됨
        return "index";
    }
}
