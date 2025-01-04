package com.example.CalendarProject.Event.Service;

import com.example.CalendarProject.Common.Code.ErrorCode;
import com.example.CalendarProject.Event.Exception.EventNullException;
import com.example.CalendarProject.Customer.Exception.InvalidCustomerInfoException;
import com.example.CalendarProject.Customer.Entity.Customer;
import com.example.CalendarProject.Customer.Repository.CustomerRepository;
import com.example.CalendarProject.Event.Dto.AddEventRequest;
import com.example.CalendarProject.Event.Dto.UpdateEventRequest;
import com.example.CalendarProject.Event.Dto.EventResponse;
import com.example.CalendarProject.Event.Entity.Event;
import com.example.CalendarProject.Event.Repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public EventResponse saveEvent(Long customerId, AddEventRequest request) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new InvalidCustomerInfoException(ErrorCode.NULL_POINT_EVENT));

        Event event = new Event(customer, request);

        Event savedEvent = eventRepository.save(event);

        return new EventResponse(savedEvent);
    }


    public EventResponse findById(Long id) {
        Event event = findEventOrElseThrowException(id);
        return new EventResponse(event);
    }


    @Transactional
    public EventResponse updateEvent(Long id, UpdateEventRequest request) {

        Event event = findEventOrElseThrowException(id);
        event.update(request);

        return new EventResponse(event);
    }


    @Transactional
    public void deleteEvent(Long id) {
        Event event = findEventOrElseThrowException(id);
        eventRepository.deleteById(id);
    }


    private Event findEventOrElseThrowException(Long id) {
        Event findEvent = eventRepository.findById(id)
                .orElseThrow(() -> new EventNullException(ErrorCode.NULL_POINT_EVENT));

        return findEvent;
    }
}