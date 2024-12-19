package com.example.CalendarProject.Controller;

import com.example.CalendarProject.CustomerDto.CustomerResponse;
import com.example.CalendarProject.CustomerDto.joinUpCustomerRequest;
import com.example.CalendarProject.CustomerDto.loginCustomerRequest;
import com.example.CalendarProject.Service.customerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar/customer")

public class CustomerController {

    private final customerService service;

    @PostMapping("/signup")
    public ResponseEntity<CustomerResponse> joinUp( @RequestBody joinUpCustomerRequest request) {
        CustomerResponse response = service.signUpCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login( @RequestBody loginCustomerRequest request, HttpServletResponse response) {


        Long customerId = service.login(request.getEmail(), request.getPassword());


        Cookie cookie = new Cookie("user_id", customerId+"");


        response.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logOut(HttpServletResponse response){
        Cookie cookie = new Cookie("user_id",null );
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
