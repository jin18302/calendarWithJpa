package com.example.CalendarProject.Event.Controller;

import com.example.CalendarProject.Event.Dto.AddEventRequest;
import com.example.CalendarProject.Event.Dto.EventResponse;
import com.example.CalendarProject.Event.Dto.UpdateEventRequest;
import com.example.CalendarProject.Event.Service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class EventController {

    private final EventService service;

    @PostMapping("/customers/{customerId}/events")
    public ResponseEntity<EventResponse> saveEvent(@PathVariable(name = "customerId") Long customerId, @Valid @RequestBody AddEventRequest request) {

        EventResponse eventResponse = service.saveEvent(customerId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventResponse);
    }


    @GetMapping("/events/{id}")
    public ResponseEntity<EventResponse> findById(@PathVariable("id") Long id) {

        EventResponse eventResponse = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }


    @PatchMapping("/events/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @Valid @RequestBody UpdateEventRequest request) {

        EventResponse eventResponse = service.updateEvent(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }


    @DeleteMapping("/events/{id}")
    public SuccessMessageResponse deleteEvent(@PathVariable Long id) {

        service.deleteEvent(id);
        return new SuccessMessageResponse(SuccessCode.DELETE_EVENT);
    }
}
