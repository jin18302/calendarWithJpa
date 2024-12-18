package com.example.CalendarProject.Service;

import com.example.CalendarProject.CustomerDto.CustomerResponse;
import com.example.CalendarProject.CustomerDto.joinUpCustomerRequest;
import com.example.CalendarProject.Entity.Customer;
import com.example.CalendarProject.Repository.customerRepository;
import com.example.CalendarProject.config.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public CustomerResponse signUpCustomer(joinUpCustomerRequest request){

        String encode = passwordEncoder.encode(request.getPassword());
        request.setPassword(encode);

        Customer customer = repository.save(request.toEntity());

        System.out.println(encode);

        return new CustomerResponse(customer);
    }

    public Long login(String email, String password){
        Optional<Customer> findCustomer = repository.findCustomerByEmail(email);

        if(findCustomer.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(401), "No member signed up with that email exists");
        }

        Customer customer = findCustomer.get();

        if(passwordEncoder.matches(password, customer.getPassword())){
            return customer.getId();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(401),"Password doesn't match");
    }

}
