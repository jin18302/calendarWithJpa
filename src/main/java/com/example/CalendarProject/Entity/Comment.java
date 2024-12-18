package com.example.CalendarProject.Entity;

import com.example.CalendarProject.Dto.CommentDto.CommentUpdateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
