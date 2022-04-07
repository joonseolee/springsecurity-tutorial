# springsecurity-tutorial

인프런 [코어-스프링-시큐리티](https://www.inflearn.com/course/%EC%BD%94%EC%96%B4-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0) 수업을 보고 순서대로 진행해봄.  
브랜치를 기준으로 공부한 각 챕터별로 나눠져있다.  
최대한 주석등을 이용해서 각 코드별 설명추가했음.  
책이외에도 쓸만한게 있으면 추가 예정.  

## 인가 결정 심의자 

* AccessDecisionManager 
    * 인증정보, 요청정보, 권한정보를 이용해 사용자를 지원접근허용할것인지 아닌지 최종 결정하는 주체.
    * 여러개의 Voter 들을 가질수있고 허용, 거부, 보류등에 해당하는 리턴받고 판단 및 결정 
    * 접근결정에 대한 3가지 유형
        * AffirmativeBased - 하나라도 허용할경우 패스
        * ConsensusBased - 다수가 허용할경우 패스
        * UnanimousBased - 모두가 허용할경우 패스
* AccessDecisionVoter
    * 판단을 심사하는것
    * 권한부여에서 판단하는 자료는 위에서 말한 인증정보, 요청정보, 권한정보이다.
    * 결정방식은 3가지 - 접근허용(1), 접근금지(-1), 접근보류(0)
    

## Mapstruct - etc

mapstruct 라이브러리를 쓸겸 이곳에 어쩌다보니 넣었다?  
대부분 기능은 사용해봤고 다만 strategy, provider 직접 구현까지는 생략했음.  
사용된 파일들의 위치는 `com.joonseolee.springsecuritytutorial.domain` 에서 확인할수있다.  

## 인가 프로세스

* UrlResourcesMapFactoryBean
    * DB 로부터 얻은 권한/자원 정보를 ResourceMap 을 빈으로 생성해서 UrlFilterInvocationSecurityMetadataSource 에 전달.
* Method 방식 - 아노테이션 권한 설정
    * @PreAuthorize, @PostAuthroize
        * SpEL 지원
        * PrePostAnnotationSecurityMetadataSource 가 담당 
    * @Secured, @RolesAllowed
        * SpEL 미지원 
        * SecuredAnnotationSecurityMetadataSource, Jsr250MethodSecurityMetadataSource 가 담당 
    
## 인가 프로세스 구현

* 인가처리를 위한 초기화 과정과 진행
    * 초기화 과정
        1. 초기화시 전체 빈을 검사하여 보안이 설정된 메소드 탐색
        2. 빈의 프록시 객체를 생성
        3. 보안 메소드에 인가처리 기능을 하는 Advice 등록
        4. 빈 참조시 실제 빈이 아닌 프록시 빈 객체를 참조
    * 진행과정
        1. 메소드 호출시 프록시 객체를 통해 메소드를 호출
        2. Advice 가 등록되어 있다면 Advice 를 작동하게 하여 인가처리
        3. 권한 심사 통과하면 실제 빈의 메소드를 호출!
    
    
