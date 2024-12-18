package com.example.CalendarProject.Dto.CommentDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateRequest {
    private String title;
    private String content;
}
