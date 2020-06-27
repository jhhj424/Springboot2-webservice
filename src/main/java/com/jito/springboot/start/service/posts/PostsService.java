package com.jito.springboot.start.service.posts;

import com.jito.springboot.start.domain.posts.Posts;
import com.jito.springboot.start.domain.posts.PostsRepository;
import com.jito.springboot.start.web.dto.PostsResponseDto;
import com.jito.springboot.start.web.dto.PostsSaveRequestDto;
import com.jito.springboot.start.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        // 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태이다.
        // 이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영한다.
        // 즉, Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다. -> 이 개념을 '더티체킹' 이라고 한다.
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}
