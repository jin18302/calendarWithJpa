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
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @CreatedDate
    @Column(name="join_date")
    private LocalDateTime joinDate;

    @Builder
    public Customer(String name, String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public void update(String name){
        this.name=name;
    }
}
