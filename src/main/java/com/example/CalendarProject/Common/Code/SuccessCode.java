package com.example.CalendarProject.Common.Code;

import lombok.Getter;

@Getter
public enum SuccessCode {


    SIGN_UP("회원가입되었습니다"),

    LOG_IN("로그인 되었습니다"),

    LOG_OUT("로그아웃 되었습니다"),

    DISCREPANCIES("회원탈퇴 되었습니다"),

    DELETE_EVENT("일정이 삭제되었습니다");


    private String message;

    SuccessCode(String Message) {
        this.message = Message;
    }
}
