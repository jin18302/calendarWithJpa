package com.example.calendarlevel1.Service;

import com.example.calendarlevel1.EventDto.addEventRequest;
import com.example.calendarlevel1.EventDto.updateEventRequest;
import com.example.calendarlevel1.EventDto.eventResponse;
import com.example.calendarlevel1.Entity.Event;
import com.example.calendarlevel1.Repository.eventRepository;
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
     return null;
    }

    public void  deleteEvent(Long id){
        Optional<Event> findEvent = repository.findById(id);

        if(findEvent.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"not found id:" + id);
        }

        repository.deleteById(id);
    }


}
