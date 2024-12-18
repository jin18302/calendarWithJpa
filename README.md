 ## 📅Project duration
2024.12.12~2024.12.18

## ⚙️Development Environment
```intelij``` ```java17```

## information
- 엔티티 각 컬럼의 제약조건 설정
- 회원 엔티티가 없기때문에 수정,삭제시 작성자가 맞는지 확인위해 password컬럼 추가


## API명세서
| 기능         | url                                        | httpmethod | request                                                     | response                                                                                        | HttpStatus |
|--------------|--------------------------------------------|------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------|------------|
| 일정추가하기 |   calendar/event                              | ```post```       | { "name":"String",  "password":"String", "title":"String", "text":"String" } | { "name":"String", "title":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }     | ```201```        |
| 일정조회     | calendar/event/{id} | ```get```| 없음 |{ "name":"String", "title":"String", "text":"String", "CreationDate":"String", "ModificationDate":"String" } | ```200```|
| 일정수정     | calendar/event/{id}                                      | ```patch```       | { "name":"String", "password":"String", "title":"String" "text":"String" }       | "name":"String", "title":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }| ```200```        |
| 삭제         | calendar/event/{id}| ```delete```|  {"password":"String"}| 없음| ```204```|

## ERD
```mermaid
erDiagram

   EVENT {
        Long id
        String password
        String title
        String content
        LocalDatetime create_at
        LocalDatetime update_at
    }
