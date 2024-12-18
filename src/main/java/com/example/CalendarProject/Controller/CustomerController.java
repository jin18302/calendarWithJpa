package com.example.CalendarProject.Controller;

import com.example.CalendarProject.CustomerDto.CustomerResponse;
import com.example.CalendarProject.CustomerDto.addCustomerRequest;
import com.example.CalendarProject.CustomerDto.updateCustomerRequest;
import com.example.CalendarProject.Service.customerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findCustomerByEmail(@PathVariable("id") Long id) {
        CustomerResponse response = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomerByEmail(@PathVariable("id") Long id, @RequestBody updateCustomerRequest request) {
        CustomerResponse response = service.updateInfo(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        service.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
