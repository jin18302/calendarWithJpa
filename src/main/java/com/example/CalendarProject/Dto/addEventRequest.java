package com.example.CalendarProject.Dto;

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
    private String author;
    private String password;
    private String title;
    private String content;

    public Event toEntity(){
    return Event.builder()
            .author(author)
            .password(password)
            .title(title)
            .content(content)
            .build();
    }
}
