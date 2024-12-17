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
    public ResponseEntity<Void> login(@Valid @RequestBody loginCustomerRequest request, HttpServletResponse response) {

        System.out.println(request.getPassword()+"password");
        System.out.println(request.getEmail()+"email");

        String customerEmail = service.login(request.getEmail(), request.getPassword());


        Cookie cookie = new Cookie("user_email", customerEmail);


        response.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logOut(HttpServletResponse response){
        Cookie cookie = new Cookie("user_email",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        System.out.println("로그아웃되었습니다");

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
