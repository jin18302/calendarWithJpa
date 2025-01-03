package com.example.CalendarProject.Common.Exception;

import com.example.CalendarProject.Common.Code.ErrorCode;
import lombok.Getter;

@Getter
public class InvalidUserInfoException extends RuntimeException {

    private int status;
    private String code;
    private String message;

    public InvalidUserInfoException(ErrorCode code) {
        this.code = code.getCode();
        this.status = code.getStatus();
        this.message = code.getMessage();
    }
}
