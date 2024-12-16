package com.example.calendarlevel1.Controller;

import com.example.calendarlevel1.CustomerDto.CustomerResponse;
import com.example.calendarlevel1.CustomerDto.addCustomerRequest;
import com.example.calendarlevel1.CustomerDto.updateCustomerRequest;
import com.example.calendarlevel1.Service.customerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar/customer")

public class CustomerController {

    private final customerService service;

    @PostMapping
    public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody addCustomerRequest request) {
        CustomerResponse response = service.saveCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerResponse> findCustomerByEmail(@PathVariable("email") String email) {
        CustomerResponse response = service.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping
    public ResponseEntity<CustomerResponse> updateCustomerByEmail(@RequestBody updateCustomerRequest request){
       CustomerResponse response = service.updateInfo(request);
       return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String email){
        service.deleteCustomer(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
