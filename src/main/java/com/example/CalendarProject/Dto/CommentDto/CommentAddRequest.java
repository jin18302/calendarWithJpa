package com.example.CalendarProject.Dto.CommentDto;

import com.example.CalendarProject.Entity.Comment;
import com.example.CalendarProject.Entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentAddRequest {
    private String content;

    public Comment toEntity(){
     return Comment.builder()
             .content(content)
             .build();
    }
}
