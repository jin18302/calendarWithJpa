
## API명세서
| 기능         | url                                        | httpmethod | request                                                     | response                                                                                        | HttpStatus |
|--------------|--------------------------------------------|------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------|------------|
| 일정추가하기 |   calendar/customer                               | ```post```       | { "name":"String",  "password":"String",  "text":"String" } | { "name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }     | ```201```        |
| 일정조회     | calendar/customer/{id}                                      | ```get```        | 없음                                                        | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 일정수정     | calendar/customer/{id}                                      | ```patch```       | { "name":String "password":"String" "text":"String" }       | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 삭제         | calendar/customer/{id}                                      | ```delete```     |  {"password":"String"}                                                        | 없음                                                                                            | ```204```        |

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
