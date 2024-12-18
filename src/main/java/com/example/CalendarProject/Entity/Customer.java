package com.example.CalendarProject.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="customer", schema = "calendarlevel2")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Event> events;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    private String email;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @CreatedDate
    @Column(name="joindate")
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
