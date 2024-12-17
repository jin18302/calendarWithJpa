package com.example.CalendarProject.CustomerDto;

import com.example.CalendarProject.Entity.Customer;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class joinUpCustomerRequest {
    private String name;


    private String email;


    private String password;

    public Customer toEntity(){
    return Customer.builder()
            .name(name)
            .email(email)
            .password(password)
            .build();
    }
}
