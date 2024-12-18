package com.example.CalendarProject.Dto.CommentDto;

import com.example.CalendarProject.Entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private String content;
    private LocalDateTime createAt;
    protected LocalDateTime updateAt;

    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createAt = comment.getCreateAt();
        this.updateAt = comment.getUpdateAt();

    }
}
