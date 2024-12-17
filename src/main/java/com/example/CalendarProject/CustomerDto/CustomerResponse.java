package com.example.CalendarProject.CustomerDto;

import com.example.CalendarProject.Entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String password;
    LocalDateTime joinDate;

    public CustomerResponse(Customer customer) {
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.password = customer.getPassword();
        this.joinDate = customer.getJoinDate();
    }
}
