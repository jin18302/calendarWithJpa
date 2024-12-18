package com.example.CalendarProject.Controller;

import com.example.CalendarProject.Dto.EventDto.addEventRequest;
import com.example.CalendarProject.Dto.EventDto.eventResponse;
import com.example.CalendarProject.Dto.EventDto.updateEventRequest;
import com.example.CalendarProject.Service.eventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar/event")

public class EventController {

    private final eventService service;

    @PostMapping
    public ResponseEntity<eventResponse> saveEvent(@Valid @RequestBody addEventRequest request){
       eventResponse eventResponse= service.saveEvent(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(eventResponse);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<eventResponse> findById(@PathVariable("id") Long id){
       eventResponse eventResponse = service.findById(id);
       return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<eventResponse> updateEvent(@PathVariable Long id, @Valid @RequestBody updateEventRequest request){
       eventResponse eventResponse = service.updateEvent(id, request);
       return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteEvent(@PathVariable Long id){
        service.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
