package com.jito.springboot.start.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
* Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
* 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가한다.
* ex ) 주문 취소 메소드의 경우!
*  order.setStatus() <-- 일반적인 set메소드의 사용 (X)
*  order.cancleOrder() <-- 명확한 목적과 의도를 나타낸 메소드 (O) : 코드만 보고 어떤 메소드인지 알 수 있음
* */
@Getter
@NoArgsConstructor // 기본 생성자 자동추가 -> public Posts(){} 생성자
@Entity // 테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭함
        // ex) SalesManager.java -> sales_manager table
public class Posts {

    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙을 나타냄
    private Long id;

    // @Column : 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    // 여기서 굳이 사용한 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있어서 사용함.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
