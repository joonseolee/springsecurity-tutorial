# springsecurity-tutorial

인프런 [코어-스프링-시큐리티](https://www.inflearn.com/course/%EC%BD%94%EC%96%B4-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0) 수업을 보고 순서대로 진행해봄.  
브랜치를 기준으로 공부한 각 챕터별로 나눠져있다.  
최대한 주석등을 이용해서 각 코드별 설명추가했음.  

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