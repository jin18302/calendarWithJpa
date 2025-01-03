package com.example.CalendarProject.Common.Code;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NULL_POINT_CUSTOMER(404, "ER1000", "존재하지 않는 회원입니다"),

    NULL_POINT_EVENT(404, "ER1001", "존재하지 않는 이벤트입니다"),

    NULL_POINT_COMMENT(404, "ER1002", "존재하지 않는 댓글입니다"),

//    MISSING_PASSWORD(400, "ER1002", "비밀번호를 입력해주세요"),
//
//    MISSING_EMAIL(400, "ER1002", "이메일을 입력해주세요"),
//
//    INVALID_USER_EMAIL(400, "ER1003", "이메일 형식이 올바르지 않습니다"),
//
//    INVALID_USER_PASSWORD(400, "ER1004", "비밀번호 형식이 올바르지 않습니다"),

    INCORRECT_EMAIL_OR_PASSWORD(400, "ER1005", "이메일 또는 비밀번호가 올바르지 않습니다"),

    ALREADY_REGISTERED_USER(400, "ER1006", "이미 존재하는 이메일입니다"),

    DISCREPANCIES_PASSWORD(400, "ER1006", "비밀번호가 일치하지 않습니다");


    private final int status;
    private String code;
    private String Message;


    ErrorCode(int status, String code, String Message) {
        this.status = status;
        this.code = code;
        this.Message = Message;
    }
}
