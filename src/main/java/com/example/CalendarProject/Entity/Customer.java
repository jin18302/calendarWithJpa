package com.example.CalendarProject.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @CreatedDate
    @Column(name="joindate")
    private LocalDateTime joinDate;

    @Builder
    public Customer(String name, String email){
        this.name=name;
        this.email=email;
    }

    public void update(String name){
        this.name=name;
    }
}
