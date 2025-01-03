package com.example.CalendarProject.Comment.Dto;

import com.example.CalendarProject.Comment.Entity.Comment;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddCommentRequest {

    @NotBlank(message = "한글자 이상 입력해주세요")
    private String content;

}
