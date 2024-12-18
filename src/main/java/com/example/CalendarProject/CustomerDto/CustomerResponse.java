package com.example.CalendarProject.CustomerDto;

import com.example.CalendarProject.Entity.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerResponse {
   private String name;
   private String email;
   private LocalDateTime joinDate;


    public CustomerResponse(Customer customer){
        this.name=customer.getName();
        this.email=customer.getEmail();
        this.joinDate=customer.getJoinDate();
    }

    @Builder
    public CustomerResponse(String name, String email, String password, LocalDateTime joinDate){
        this.name=name;
        this.email=email;
        this.joinDate=joinDate;
    }
}
