package com.example.CalendarProject.EventDto;

import lombok.Getter;

@Getter
public class updateEventRequest {
    private String email;
    private String title;
    private String content;
}
