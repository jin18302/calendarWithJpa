package com.example.CalendarProject.Customer.Dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerRequest {

    @NotNull
    @Email(message = "유효하지 않은 이메일 형식입니다")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-_=+{};:,<.>]).{8,}$",
            message = "특수문자, 숫자, 대문자를 포함해 최소8자 이상 입력해주세요")
    private String password;
}
