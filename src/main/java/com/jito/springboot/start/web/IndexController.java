package com.jito.springboot.start.web;

import com.jito.springboot.start.config.auth.LoginUser;
import com.jito.springboot.start.config.auth.dto.SessionUser;
import com.jito.springboot.start.service.posts.PostsService;
import com.jito.springboot.start.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { // @LoginUser SessionUser user : 를 이용해서 세션 정보를 가져올 수 있음
        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser)httpSession.getAttribute("user"); // CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성함, 로그인 성공기 user값을 가져올 수 있음
        if(user != null) { // 세션에 저장된 값이 있을 때만 model 에 userName으로 등록함, 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 화면에선 로그인 버튼이 보이게 됨
            model.addAttribute("loginUserName", user.getName());
        }
        // 머스테치 스타터 덕분에 src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리하게됨
        return "main";
//        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
