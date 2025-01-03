package com.example.CalendarProject.Comment.Entity;

import com.example.CalendarProject.Comment.Dto.AddCommentRequest;
import com.example.CalendarProject.Comment.Dto.UpdateCommentRequest;
import com.example.CalendarProject.Customer.Entity.Customer;
import com.example.CalendarProject.Entity.Event;
import jakarta.persistence.*;
import lombok.*;
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
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name="content")
    private String content;

    @CreatedDate
    @Column(name="create_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name="update_at")
    private LocalDateTime updateAt;

    @Builder
    public Comment(Customer customer, Event event, AddCommentRequest request){
        this.customer = customer;
        this.event = event;
        this.content = request.getContent();
    }

    public void update(UpdateCommentRequest request){
        this.content = request.getContent();
    }

}
