## 프로젝트 설명

기존 구현코드의 연관관계 구현 부분 수정 및, casecade구현</br>
</br>
globarExceptionHandler를 사용한 예외처리를 통해 클라이언트에게 예외의 원인을 제공</br>
</br>
sucessCode와 exceptionCode 를 enum타입으로 지정</br>
</br>
요청을 성공적으로 처리했지만 repository에 데이터를 넘길 필요가 없을 때 MessageResponse를 통한 성공메시지 반환</br>



## API명세서

| 기능         | url                                        | httpmethod | request                                                     | response                                                                                        | HttpStatus |
|--------------|--------------------------------------------|------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------|------------|
| 일정추가하기 |   calendar/event                              | ```post```       | { "name":"String",  "password":"String", "title":"String", "text":"String" } | { "name":"String", "title":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }     | ```201```        |
| 일정조회     | calendar/event/{id} | ```get```| 없음 |{ "name":"String", "title":"String", "text":"String", "CreationDate":"String", "ModificationDate":"String" } | ```200```|
| 일정수정     | calendar/event/{id}                                      | ```patch```       | { "name":"String", "password":"String", "title":"String" "text":"String" }       | "name":"String", "title":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }| ```200```        |
| 삭제         | calendar/event/{id}| ```delete```|  {"password":"String"}| 없음| ```204```        |
|일정삭제         | calendar/event/{id}| ```delete```     |  {"password":"String"}   | 없음  | ```204```        |
|회원가입|calendar/customer/signup|```post```|{"email":"String", "password":"String", "name":"String"}|{"id":"Long","email":"String", "password":"String", "name":"String", "joindate":"Localdatetime"}|```201```
|로그인|calendar/customer/login|```post```|{"email":"String", "password":"String"}|없음|```200```|
|로그아웃|calendar/customer/logout|```post```|없음|없음|```200```|
|댓글생성|calendar/comment|```post```|{"title":"String", "content":"String"}|{"id":"Long", "title":"String", "content":"String","createAt":"LocalDateTime","updateAt":"LocalDateTime"}|```201```|
|댓글조회|calendar/comment/{id}|```get```|없음|{"id":"Long", "content":"String","createAt":"LocalDateTime","updateAt":"LocalDateTime"}|```200```|
|댓글수정|calendar/comment/{id}|```patch```|{"content":"String"}|{"id":"Long", "content":"String","createAt":"LocalDateTime","updateAt":"LocalDateTime"}|```200```|
|댓글삭제|calendar/comment/{id}|```delete```|없음|없음|```200```|


## ERD
```mermaid
erDiagram

   EVENT {
        Long id
        String title
        String content
        CUSTOMER customer_id
        LocalDatetime create_at
        LocalDatetime update_at
    }

    CUSTOMER{
        Long id
        String email
        String password
        String name
        LocalDatetime join_date
    }

    COMMENT{
        Long id
        CUSTOMER customer_id
        EVENT event_id
        String title
        String content
        LocalDatetime create_at
        LocalDatetime update_at
    }
    CUSTOMER ||--o{ EVENT : "create"
    CUSTOMER ||--o{ COMMENT : "create"
    EVENT ||--o{ COMMENT : "create"
