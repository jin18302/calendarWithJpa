package com.example.CalendarProject.Dto.CommentDto;

import com.example.CalendarProject.Entity.Comment;
import com.example.CalendarProject.Entity.Customer;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentAddRequest {
    @NotBlank
    private String content;

    public Comment toEntity(){
     return Comment.builder()
             .content(content)
             .build();
    }
}
