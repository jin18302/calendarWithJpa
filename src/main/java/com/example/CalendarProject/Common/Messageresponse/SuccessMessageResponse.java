package com.example.CalendarProject.Common.Messageresponse;

import com.example.CalendarProject.Common.Code.SuccessCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class SuccessMessageResponse {

    private String message;

    public SuccessMessageResponse(SuccessCode code){
        log.info("확인: "+code.getMessage());
        this.message = code.getMessage();
    }
}
