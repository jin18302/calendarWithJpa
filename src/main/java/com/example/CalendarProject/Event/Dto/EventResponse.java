package com.example.CalendarProject.Event.Dto;

import com.example.CalendarProject.Event.Entity.Event;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EventResponse {
    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;



    public EventResponse(Event event){
        this.id = event.getId();
        this.title = event.getTitle();
        this.content = event.getContent();
        this.createdAt = event.getCreatedAt();
        this.updateAt = event.getUpdateAt();
    }
}
