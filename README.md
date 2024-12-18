erDiagram
    USER {
        int id
        string name
        string email
    }
    POST {
        int id
        string title
        string content
        int user_id
    }
    COMMENT {
        int id
        string content
        int post_id
        int user_id
    }

    USER ||--o| POST : "writes"
    POST ||--o| COMMENT : "has"
    USER ||--o| COMMENT : "makes"
