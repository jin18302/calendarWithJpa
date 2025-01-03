package com.example.CalendarProject.Common.Code;

import lombok.Getter;

@Getter
public enum SuccessCode {


    SIGN_UP(201,  "회원가입되었습니다"),

    LOG_IN(204, "로그인 되었습니다"),

    LOG_OUT(204,  "로그아웃 되었습니다"),

    DISCREPANCIES(204, "회원탈퇴 되었습니다"),

    DELETE_EVENT(204, "일정이 삭제되었습니다");


    private final int status;
    private String message;

    SuccessCode(int status, String Message) {
        this.status = status;
        this.message = Message;
    }
}
