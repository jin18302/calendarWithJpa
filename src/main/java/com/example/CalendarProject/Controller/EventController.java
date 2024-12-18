package com.example.CalendarProject.Controller;

import com.example.CalendarProject.Dto.addEventRequest;
import com.example.CalendarProject.Dto.deleteEventRequest;
import com.example.CalendarProject.Dto.eventResponse;
import com.example.CalendarProject.Dto.updateEventRequest;
import com.example.CalendarProject.Service.eventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class EventController {
    private final eventService service;

    @PostMapping
    public ResponseEntity<eventResponse> saveEvent(@RequestBody addEventRequest request){
       eventResponse eventResponse= service.saveEvent(request);
       return ResponseEntity.status(HttpStatus.CREATED).body(eventResponse);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<eventResponse> findById(@PathVariable("id") Long id){
       eventResponse eventResponse = service.findById(id);
       return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<eventResponse> updateEvent(@PathVariable Long id, @RequestBody updateEventRequest request){
       eventResponse eventResponse = service.updateEvent(id, request);
       return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteEvent(@PathVariable Long id, @RequestBody deleteEventRequest request){
        service.deleteEvent(id,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
