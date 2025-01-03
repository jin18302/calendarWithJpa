package com.example.CalendarProject.Event.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEventRequest {

    @NotBlank(message = "제목을 한글지 이상 입력해주세요")
    private String title;

    @Max(value = 50, message = "최대입력 글자수는 50자입니다")
    private String content;
}
