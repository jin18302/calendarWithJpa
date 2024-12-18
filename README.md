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
        Long id
        string email
        string name
        LocalDatetime join_date
        
    }
   EVENT {
        Long id
        CUSTOMER customer_id
        String title
        String content
        LocalDatetime create_at
        LocalDatetime update_at
    }
    CUSTOMER ||--o{ EVENT : "create"
