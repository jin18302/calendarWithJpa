package com.example.CalendarProject.CustomerDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class loginCustomerRequest {
    private String email;

    private String password;
}
