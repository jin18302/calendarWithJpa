package com.example.CalendarProject.Service;

import com.example.CalendarProject.Dto.addEventRequest;
import com.example.CalendarProject.Dto.deleteEventRequest;
import com.example.CalendarProject.Dto.updateEventRequest;
import com.example.CalendarProject.Dto.eventResponse;
import com.example.CalendarProject.Entity.Event;
import com.example.CalendarProject.Repository.eventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class eventService {

    private final eventRepository repository;

    public eventResponse saveEvent(addEventRequest request) {
        Event event = repository.save(request.toEntity());
        return new eventResponse(event);
    }

    public eventResponse findById(Long id) {
        Optional<Event> event = repository.findById(id);
        if (event.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found id:" + id);
        }
        return new eventResponse(event.get());
    }

    @Transactional
    public eventResponse updateEvent(Long id, updateEventRequest request) {
        Optional<Event> findEvent = repository.findById(id);

        if (findEvent.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found id:" + id);
        }

        Event event = findEvent.get();

        if (!event.checkPassword(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password doesn't match");
        }
        event.update(request);
        return new eventResponse(event);
    }

    public void  deleteEvent(Long id, deleteEventRequest request){
        Optional<Event> findEvent = repository.findById(id);

        if(findEvent.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"not found id:" + id);
        }

        Event event = findEvent.get();

        if (!event.checkPassword(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password doesn't match");
        }
        repository.deleteById(id);
    }


}
