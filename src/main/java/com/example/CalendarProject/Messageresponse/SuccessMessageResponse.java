package com.example.CalendarProject.Messageresponse;

import com.example.CalendarProject.Common.Code.SuccessCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class SuccessMessageResponse {

    private int status;
    private String message;

    public SuccessMessageResponse(SuccessCode code){
        log.info("확인: "+code.getMessage());
        this.message = code.getMessage();
        this.status = code.getStatus();
    }
}
