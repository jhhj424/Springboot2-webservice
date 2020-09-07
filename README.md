# springboot2-webservice [![Build Status](https://travis-ci.org/brainbackdoor/bbd-lotto.svg)](https://travis-ci.org/brainbackdoor/bbd-lotto)

스프링 부트와 AWS으로 구현한 웹 서비스<br>
http://ec2-15-164-117-59.ap-northeast-2.compute.amazonaws.com/

## 프로젝트 환경 점검
  - Java 8
  - spring Boot 2.1.* (2.1.7)
  - Gradle 4.x (4.4)
  
현재 spring.io 에서 만들어주는 기본 환경인 Spring Boot 2.2.x와 Gradle 5.x에서는 정상작동 하지 않음

Spring Boot 2.2와 Gradle 5로 오면서 너무 많은 설정들이 변경되었고, 현재 실무에서 가장 많이 사용되는 버전인 2.1.x와 Gradle 4을 선택함.

## 기술 스택
  - Spring Boot
  - Spring Security 
  - JUnit
  - JPA
  - Mustache
  - OAuth 2.0
  - AWS (EC2, RDS, S3, CodeDeploy)
  - Travis CI
  - Nginx
  
## 본 프로젝트를 통해..
 - JUnit을 이용한 테스트 방법을 익히고 테스트 코드의 중요성을 인지하고 사용함
 - AWS 인프라에 대한 기본 사용법과 서비스를 할 수 있는 수준의 설정을 익힘
 - 배포 자동화와 무중단 배포 환경을 구축함
