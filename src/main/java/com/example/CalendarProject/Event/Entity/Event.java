package com.example.CalendarProject.Event.Entity;

import com.example.CalendarProject.Customer.Entity.Customer;
import com.example.CalendarProject.Event.Dto.AddEventRequest;
import com.example.CalendarProject.Event.Dto.UpdateEventRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;


@Getter
@Entity @Table(name="event")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;


    public Event(Customer customer, AddEventRequest request) {
        this.customer = customer;
        this.title = request.getTitle();
        this.content = request.getContent();
    }

    public void update(UpdateEventRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
