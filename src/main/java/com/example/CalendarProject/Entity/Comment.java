package com.example.CalendarProject.Entity;

import com.example.CalendarProject.Dto.CommentDto.CommentUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment {

    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event eventId;

    @Column(name="content")
    private String content;

    @CreatedDate
    @Column(name="create_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name="update_at")
    private LocalDateTime updateAt;

    @Builder
    public Comment( String content){
        this.content=content;
    }

    public void update(CommentUpdateRequest request){
        this.content = request.getContent();
    }

}
