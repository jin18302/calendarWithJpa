package com.example.CalendarProject.Dto.EventDto;

import com.example.CalendarProject.Entity.Event;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class addEventRequest  {
    @NotBlank(message = "1글자 이상 작성해주십시오")
    @Size(max = 15, message = "최대 글자수는 15자입니다")
    private String title;

    @NotBlank(message = "1글자 이상 작성해주십시오")
    @Size(max = 30, message = "최대 글자수는 15자입니다")
    private String content;

    public Event toEntity(){
    return Event.builder()
            .title(title)
            .content(content)
            .build();
    }
}
