package com.example.calendarlevel1.Entity;

import com.example.calendarlevel1.Dto.updateEventRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
    private  Long id;

    @Column(name="author", length = 10, updatable = false, nullable = false)
    private String author;

    @Column(name="password", length = 10, updatable = false)
    private String password;

    @Column(name="title", length = 20, nullable = false)
    private String title;

    @Column(name="content", length = 30, nullable = false)
    private String content;

    @CreatedDate
    @Column(name="created_at",  updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="update_at")
    private LocalDateTime updateAt;

    @Builder
    public Event(String author, String password, String title, String content){
        this.author=author;
        this.password=password;
        this.title=title;
        this.content=content;
    }

    public void update(updateEventRequest request){
        this.title=request.getTitle();
        this.content=request.getContent();
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
}
