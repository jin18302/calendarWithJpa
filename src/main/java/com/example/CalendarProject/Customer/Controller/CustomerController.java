package com.example.CalendarProject.Customer.Controller;

import com.example.CalendarProject.Common.Code.SuccessCode;
import com.example.CalendarProject.Customer.Dto.CustomerSecessionRequest;
import com.example.CalendarProject.Customer.Dto.SignUpCustomerRequest;
import com.example.CalendarProject.Customer.Dto.LoginCustomerRequest;
import com.example.CalendarProject.Common.Messageresponse.SuccessMessageResponse;
import com.example.CalendarProject.Customer.Service.CustomerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar/customers")
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/signup")
    public ResponseEntity<SuccessMessageResponse> joinUp(@Valid @RequestBody SignUpCustomerRequest request) {
        log.info("컨트롤러가 호출되었습니다");

        service.signUpCustomer(request);

        SuccessMessageResponse response = new SuccessMessageResponse(SuccessCode.SIGN_UP);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/login")
    public ResponseEntity<SuccessMessageResponse> login(@Valid @RequestBody LoginCustomerRequest request, HttpServletResponse response) {
        log.info("컨트롤러가 호출되었습니다");

        Long customerId = service.login(request.getEmail(), request.getPassword());

        Cookie cookie = new Cookie("user_id", customerId + "");

        response.addCookie(cookie);

        SuccessMessageResponse responseMessage = new SuccessMessageResponse(SuccessCode.SIGN_UP);
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }


    @PostMapping("/logout")
    public ResponseEntity<SuccessMessageResponse> logOut(HttpServletResponse response) {
        log.info("컨트롤러가 호출되었습니다");

        Cookie cookie = new Cookie("user_id", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        SuccessMessageResponse messageResponse = new SuccessMessageResponse(SuccessCode.LOG_OUT);

        return ResponseEntity.status(HttpStatus.OK).body(messageResponse);

    }


    @DeleteMapping("/{customerid}")
    public ResponseEntity<SuccessMessageResponse> secession(@PathVariable("customerid") Long customerId,
                                                            @RequestBody CustomerSecessionRequest request) {
        log.info("컨트롤러가 호출되었습니다");

        service.secession(customerId, request);

        SuccessMessageResponse response = new SuccessMessageResponse(SuccessCode.DISCREPANCIES);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
