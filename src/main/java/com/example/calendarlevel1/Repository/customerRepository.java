package com.example.calendarlevel1.Repository;

import com.example.calendarlevel1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository<Customer,String> {
    Optional<Customer> findCustomerByEmail(String email);

    void deleteByEmail(String email);
}
