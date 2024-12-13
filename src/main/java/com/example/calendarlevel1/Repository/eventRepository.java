package com.example.calendarlevel1.Repository;

import com.example.calendarlevel1.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends JpaRepository<Event,Long> {
}
