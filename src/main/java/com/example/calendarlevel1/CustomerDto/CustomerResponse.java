package com.example.calendarlevel1.CustomerDto;

import com.example.calendarlevel1.Entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerResponse {
    String name;
    String email;
    LocalDateTime joinDate;

    public CustomerResponse(Customer customer){
        this.name=customer.getName();
        this.email=customer.getEmail();
        this.joinDate=customer.getJoinDate();
    }
}
