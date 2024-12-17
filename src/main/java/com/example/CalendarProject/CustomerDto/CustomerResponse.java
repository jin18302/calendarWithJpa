package com.example.CalendarProject.CustomerDto;

import com.example.CalendarProject.Entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerResponse {
    String name;
    String email;
    String password;
    LocalDateTime joinDate;

    public CustomerResponse(Customer customer){
        this.name=customer.getName();
        this.email=customer.getEmail();
        this.password=customer.getPassword();
        this.joinDate=customer.getJoinDate();
    }
}
