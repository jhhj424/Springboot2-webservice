package com.jito.springboot.start.config.auth.dto;

import com.jito.springboot.start.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/*
* User 클래스를 사용하지않고 SessionUser클래스를 따로 생성해서 사용하는 이유 !!
*  - User 클래스를 세션에 저장하려고 하면 User클래스에 직렬화를 구현하지 않았다는 의미의 에러가 발생함, 이 오류를 해결하기 위해 User 클래스에 직렬화 코드를 넣는것에는 생각해볼게 많다.
*    그 이유는 User 클래스는 엔티티로 생성이 되었기 때문에 언제 다른 엔티티와 관계가 형성될지 모른다. 자식엔티티를 가지고 있다면 직렬화 대상에 자식들까지 포함이되고 성능이슈,부수효과가 발생할 확률이 높다.
*    그래서 직렬화 기능을 가진 세션Dto를 하나 추가로 만들어 사용하는것이 이후 운영 및 유지보수 때 많은 도움이 된다.
* */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
