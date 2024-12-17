package com.example.CalendarProject.EventDto;

import com.example.CalendarProject.Entity.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class addEventRequest  {
    private String title;
    private String content;

    public Event toEntity(){
    return Event.builder()
            .title(title)
            .content(content)
            .build();
    }
}