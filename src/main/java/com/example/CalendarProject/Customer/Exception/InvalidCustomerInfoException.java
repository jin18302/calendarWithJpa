package com.example.CalendarProject.Customer.Exception;

import com.example.CalendarProject.Common.Code.ErrorCode;
import lombok.Getter;

@Getter
public class InvalidCustomerInfoException extends RuntimeException {

    private int status;
    private String code;
    private String message;

    public InvalidCustomerInfoException(ErrorCode code) {
        this.code = code.getCode();
        this.status = code.getStatus();
        this.message = code.getMessage();
    }
}
