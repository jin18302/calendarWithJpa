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
