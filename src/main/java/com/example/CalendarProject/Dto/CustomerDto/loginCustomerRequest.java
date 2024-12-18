package com.example.CalendarProject.Dto.CustomerDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class loginCustomerRequest {
    @Email(message = "입력하신 문자가 email 형식과 일치하지 않습니다")
    @NotNull(message = "이메일을 작성해 주세요")
    private String email;

    @NotBlank(message = "공백과 빈문자를 허용하지 않습니다")
    @Size(min = 7, max = 12, message = "7자 이상 12글자 이하로 작성해주십시오")
    private String password;
}
