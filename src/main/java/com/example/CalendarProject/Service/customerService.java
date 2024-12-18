package com.example.CalendarProject.Service;

import com.example.CalendarProject.Dto.CustomerDto.CustomerResponse;
import com.example.CalendarProject.Dto.CustomerDto.joinUpCustomerRequest;
import com.example.CalendarProject.Entity.Customer;
import com.example.CalendarProject.Repository.customerRepository;
import com.example.CalendarProject.config.PasswordEncoder;
import lombok.*;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Setter
@Getter
public class customerService {

    private final customerRepository repository;
    private final PasswordEncoder passwordEncoder;

    public CustomerResponse signUpCustomer(joinUpCustomerRequest request){

        String encode = passwordEncoder.encode(request.getPassword());//인코딩된 비밀번호
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
