package com.example.CalendarProject.Messageresponse;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionMessageResponse {
    private int status;
    private String errCode;
    private String Message;

    @Builder
    public ExceptionMessageResponse(int status, String errCode, String message) {
        this.status = status;
        this.errCode = errCode;
        this.Message = message;
    }

//    public ExceptionMessageResponse(HttpStatusCode code, String Message) {
//        this.status = status;
//        this.code = code;
//        this.Message = Message;
//    }
}
