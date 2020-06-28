package com.jito.springboot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing // JPA Audiding 활성화 (JPA Audiding : 시간에 대해서 자동으로 값을 넣어주는 기능) - 사용하기 위해선 최소 하나의 @Entity 클래스가 필요함!
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
