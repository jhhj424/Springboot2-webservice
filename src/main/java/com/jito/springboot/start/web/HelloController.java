package com.jito.springboot.start.web;

import com.jito.springboot.start.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러로 만들어준다.
public class HelloController {

    @GetMapping("/hello") // HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어준다.
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    // @RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
