package com.example.CalendarProject.EventDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class updateEventRequest {
    @NotBlank(message = "1글자 이상 작성해주십시오")
    @Size(max = 15, message = "최대 글자수는 15자입니다")
    private String title;

    @NotBlank(message = "1글자 이상 작성해주십시오")
    @Size(max = 30, message = "최대 글자수는 15자입니다")
    private String content;
}
