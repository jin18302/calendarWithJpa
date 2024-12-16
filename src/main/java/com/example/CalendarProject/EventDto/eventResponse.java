package com.example.CalendarProject.EventDto;

import com.example.CalendarProject.Entity.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class eventResponse {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public eventResponse(Event event){
        this.id=event.getId();
        this.title=event.getTitle();
        this.content= event.getContent();
        this.createdAt=event.getCreatedAt();
        this.updateAt=event.getUpdateAt();
    }
}
