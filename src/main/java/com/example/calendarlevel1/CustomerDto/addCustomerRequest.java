package com.example.calendarlevel1.CustomerDto;

import com.example.calendarlevel1.Entity.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addCustomerRequest {
    private String name;
    private String email;

    public Customer toEntity(){
    return Customer.builder()
            .name(name)
            .email(email)
            .build();
    }
}
