package com.example.CalendarProject.Common.Code;

import lombok.Getter;

@Getter
public enum ErrorCode  {

    NULL_POINT_CUSTOMER(404, "ERR001", "존재하지 않는 회원입니다"),

    NULL_POINT_EVENT(404, "ERR002", "존재하지 않는 이벤트입니다"),

    NULL_POINT_COMMENT(404, "ER1002", "존재하지 않는 댓글입니다"),

    INCORRECT_EMAIL_OR_PASSWORD(400, "ERR003", "이메일 또는 비밀번호가 올바르지 않습니다"),

    ALREADY_REGISTERED_USER(400, "ERR004", "이미 존재하는 이메일입니다"),

    DISCREPANCIES_PASSWORD(400, "ERR005", "비밀번호가 일치하지 않습니다");


    private final int status;
    private String code;
    private String Message;


    ErrorCode(int status, String code, String Message) {
        this.status = status;
        this.code = code;
        this.Message = Message;
    }
}
