package com.example.calendarlevel1.Service;

import com.example.calendarlevel1.CustomerDto.CustomerResponse;
import com.example.calendarlevel1.CustomerDto.addCustomerRequest;
import com.example.calendarlevel1.CustomerDto.updateCustomerRequest;
import com.example.calendarlevel1.Entity.Customer;
import com.example.calendarlevel1.Repository.customerRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.http.HttpStatus;
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

    public CustomerResponse saveCustomer(addCustomerRequest request){
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(request.getEmail());

        if(!matcher.matches()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email format is incorrect."+request.getEmail());
        }

        Customer customer = repository.save(request.toEntity());

        return new CustomerResponse(customer);
    }

    public CustomerResponse findByEmail(String email){
        Optional<Customer> findCustomer = repository.findCustomerByEmail(email);

        if(findCustomer.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email was not found");
        }

        Customer customer = findCustomer.get();
        return new CustomerResponse(customer);

    }

    public CustomerResponse updateInfo(updateCustomerRequest request){

        Optional<Customer> findCustomer = repository.findCustomerByEmail(request.getEmail());

        if(findCustomer.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email was not found");
        }

        Customer customer = findCustomer.get();
        customer.update(request.getName());

        return new CustomerResponse(customer);
    }

    @Transactional
    public void deleteCustomer(String email){
       Optional<Customer> findCustomer = repository.findCustomerByEmail(email);

       if(findCustomer.isEmpty()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email was not found");
       }

       repository.deleteByEmail(email);

    }

}
