package com.example.CalendarProject.Comment.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentRequest {

    @NotBlank(message = "한글자 이상 입력해주세요")
    private String content;
}
