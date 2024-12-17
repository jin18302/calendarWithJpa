package com.example.CalendarProject.Service;

import com.example.CalendarProject.CustomerDto.CustomerResponse;
import com.example.CalendarProject.CustomerDto.addCustomerRequest;
import com.example.CalendarProject.CustomerDto.updateCustomerRequest;
import com.example.CalendarProject.Entity.Customer;
import com.example.CalendarProject.Repository.customerRepository;
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

    public CustomerResponse findById(Long id){
        Optional<Customer> findCustomer = repository.findCustomerById(id);

        if(findCustomer.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email was not found");
        }

        Customer customer = findCustomer.get();
        return new CustomerResponse(customer);

    }

    public CustomerResponse updateInfo(Long id, updateCustomerRequest request){

        Optional<Customer> findCustomer = repository.findCustomerById(id);

        if(findCustomer.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email was not found");
        }

        Customer customer = findCustomer.get();
        customer.update(request.getName());

        return new CustomerResponse(customer);
    }

    @Transactional
    public void deleteCustomer(Long id){
       Optional<Customer> findCustomer = repository.findCustomerById(id);

       if(findCustomer.isEmpty()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email was not found");
       }

       repository.deleteById(id);

    }

}
