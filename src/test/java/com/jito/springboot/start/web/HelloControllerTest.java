package com.jito.springboot.start.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// RunWith : 테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
// 여기서는 SpringRunner라는 스프링 실행자를 사용한다.
// 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.
@RunWith(SpringRunner.class)
// WebMvcTest : Web(Spring MVC)에 집중할 수 있는 어노테이션이다.
// 선언할경우 @Controller, @ControllerAdvice등은 사용할 수 있다.
// 단, @Service, @Component, @Repository등은 사용할 수 없다.
// 여기서는 컨트롤러만 사용하기 때문에 선언한다.
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입 받는다.
    private MockMvc mvc;// 웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점, 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다. 체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있다.
        mvc.perform(get("/hello"))
                // mvc.perform의 결과를 검증한다. HTTP Header의 Status를 검증한다.
                .andExpect(status().isOk())
                // mvc.perform의 결과를 검증한다. 응답 본문의 내용을 검증한다. Contoroller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.
                .andExpect(content().string(hello));
    }
}