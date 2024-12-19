 ## 📅Project duration
2024.12.12~2024.12.18

## ⚙️Development Environment
```intelij``` ```java17```

## information
- 댓글, 사용자, 일정 연관관계 양방향 설정, casecade적용
- 댓글 crud기능 구현


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

   erDiagram

    EVENT {
        BIGINT id PK
        VARCHAR(255) title
        TEXT content
        BIGINT customer_id FK
        DATETIME create_at
        DATETIME update_at
    }

    CUSTOMER {
        BIGINT id PK
        VARCHAR(255) email
        VARCHAR(255) password
        VARCHAR(255) name
        DATETIME join_date
    }

    COMMENT {
        BIGINT id PK
        BIGINT customer_id FK
        BIGINT event_id FK
        VARCHAR(255) title
        TEXT content
        DATETIME create_at
        DATETIME update_at
    }

    CUSTOMER ||--o{ EVENT : "creates"
    CUSTOMER ||--o{ COMMENT : "creates"
    EVENT ||--o{ COMMENT : "has"
