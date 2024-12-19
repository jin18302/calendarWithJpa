 ## 📅Project duration
2024.12.12~2024.12.18

## ⚙️Development Environment
```intelij``` ```java17```

## information
- 회원엔티티와 일정엔티티 양방향연관관계 설정, casecade 설정(=회원 삭제시 그 회원이 작성한 일정까지 모두 삭제)</br>
- 회원이 생김으로써 필요없어진 기존 일정엔티티 필드 제거

## API명세서
| 기능         | url                                        | httpmethod | request                                                     | response                                                                                        | HttpStatus |
|--------------|--------------------------------------------|------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------|------------|
| 일정추가하기 |   calendar/event                              | ```post```       | { "name":"String",  "password":"String", "title":"String", "text":"String" } | { "name":"String", "title":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }     | ```201```        |
| 일정조회     | calendar/event/{id} | ```get```| 없음 |{ "name":"String", "title":"String", "text":"String", "CreationDate":"String", "ModificationDate":"String" } | ```200```|
| 일정수정     | calendar/event/{id}                                      | ```patch```       | { "name":"String", "password":"String", "title":"String" "text":"String" }       | "name":"String", "title":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }| ```200```        |
| 삭제         | calendar/event/{id}| ```delete```|  {"password":"String"}| 없음| ```204```        |
|일정삭제         | calendar/event/{id}| ```delete```     |  {"password":"String"}   | 없음  | ```204```        |
|회원추가|calendar/customer|```post```|{"email":"String", "name":"String"}|{"id":"Long", "email":"String", "name":"String","joindate":"LocalDateTime"}|```201```
|회원조회|calendar/customer/{id}|```get```|없음|{"id":"Long", "email":"String", "name":"String","joindate":"LocalDateTime"}|```200```
|회원정보수정|calendar/customer/{id}|```patch```|{"email":"String", "name":"String", "password":"String"}|{"id":"Long", "email":"String", "name":"String","joindate":"LocalDateTime"}|```200```
|회원삭제|calendar/customer/{id}|```delete```|{"email":"String"}|없음|```200```





## ERD
```mermaid
erDiagram
    CUSTOMER {
        BIGINT id PK
        VARCHAR(255) email
        VARCHAR(255) name
        DATETIME join_date
    }
    EVENT {
        BIGINT id PK
        BIGINT customer_id FK
        VARCHAR(255) title
        TEXT content
        DATETIME create_at
        DATETIME update_at
    }
    CUSTOMER ||--o{ EVENT : "creates"
