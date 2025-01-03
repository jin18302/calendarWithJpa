package com.example.CalendarProject.Customer.Repository;

import com.example.CalendarProject.Customer.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findCustomerByEmail(String email);

    boolean existsByEmail(String email);
}
