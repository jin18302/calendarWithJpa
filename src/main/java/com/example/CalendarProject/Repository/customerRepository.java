package com.example.CalendarProject.Repository;

import com.example.CalendarProject.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository<Customer,Long> {
}
