package com.example.CalendarProject.Common.Messageresponse;

import lombok.*;

@Getter
@NoArgsConstructor
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
}
