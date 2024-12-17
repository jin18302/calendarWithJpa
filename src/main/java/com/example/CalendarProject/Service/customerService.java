package com.example.CalendarProject.Service;

import com.example.CalendarProject.CustomerDto.CustomerResponse;
import com.example.CalendarProject.CustomerDto.joinUpCustomerRequest;
import com.example.CalendarProject.Entity.Customer;
import com.example.CalendarProject.Repository.customerRepository;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Setter
@Getter
public class customerService {

    private final customerRepository repository;

    public CustomerResponse signUpCustomer(joinUpCustomerRequest request){
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(request.getEmail());

        if(!matcher.matches()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email format is incorrect."+request.getEmail());
        }

        Customer customer = repository.save(request.toEntity());

        System.out.println("회원가입되었습니다");

        return new CustomerResponse(customer);
    }

    public Long login(String email, String password){
        Optional<Customer> findCustomer = repository.findCustomerByEmail(email);
        System.out.println("-");

        if(findCustomer.isEmpty()){

            throw new ResponseStatusException(HttpStatusCode.valueOf(401), "No member signed up with that email exists");

        }
        Customer customer = findCustomer.get();

        if(!customer.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatusCode.valueOf(401),"Password doesn't match");
        }


        System.out.println(customer.getEmail());

        System.out.println("로그인되었습니다");

        return customer.getId();
    }

}
