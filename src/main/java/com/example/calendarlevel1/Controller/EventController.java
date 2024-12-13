package com.example.calendarlevel1.Controller;

import com.example.calendarlevel1.Dto.addEventRequest;
import com.example.calendarlevel1.Dto.eventResponse;
import com.example.calendarlevel1.Dto.updateEventRequest;
import com.example.calendarlevel1.Service.eventService;
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
    public ResponseEntity<Void>deleteEvent(@PathVariable Long id){
        service.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
