package com.jito.springboot.start.web;

import com.jito.springboot.start.service.posts.PostsService;
import com.jito.springboot.start.web.dto.PostsResponseDto;
import com.jito.springboot.start.web.dto.PostsSaveRequestDto;
import com.jito.springboot.start.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*
 * Service에 @Autowired가 없는 이유 : 스프링에서 Bean을 주입받는 방식에는 @Autowired, setter, 생성자 - 이렇게 3가지의 방법이 있다.
 * 이 중 가장 권장하는 방식이 생성자로 주입받는 방식이다(@Autowired는 권장하지 않음), 즉 생성자로 Bean 객체를 받도록 하면
 * @Autowired와 동일한 효과를 볼 수 있다.
 * 생성자는 @RequiredArgsConstructor에서 해결해준다. - final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성해주기 때문
 *
[ !!생성자 주입의 사용을 권장하는 이유!! ]
● 순환 참조를 방지할 수 있다.
    - 순환 참조가 발생하는 경우 애플리케이션이 구동되지 않는다.
● 테스트 코드 작성이 편리하다.
    - 단순 POJO를 이용한 테스트 코드를 만들 수 있다.
● 나쁜 냄새를 없앤다.
    - 조금 더 품질 좋은 코드를 만들 수 있다.
● immutable 하다.
    - 실행 중에 객체가 변하는 것을 막을 수 있다.
    - 오류를 사전에 방지할 수 있다.
 * */

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
