## API명세서

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
