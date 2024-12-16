package com.example.CalendarProject.Repository;

import com.example.CalendarProject.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends JpaRepository<Event,Long> {
}
