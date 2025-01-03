package com.example.CalendarProject.Customer.Service;

import com.example.CalendarProject.Common.Code.ErrorCode;
import com.example.CalendarProject.Common.Exception.InvalidUserInfoException;
import com.example.CalendarProject.Config.PasswordEncoder;
import com.example.CalendarProject.Customer.Dto.CustomerResponse;
import com.example.CalendarProject.Customer.Dto.CustomerSecessionRequest;
import com.example.CalendarProject.Customer.Dto.JoinUpCustomerRequest;
import com.example.CalendarProject.Customer.Entity.Customer;
import com.example.CalendarProject.Customer.Repository.CustomerRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;


    public CustomerResponse signUpCustomer(JoinUpCustomerRequest request) {
        log.info("서비스가 호출되었습니다");

        if (repository.existsByEmail(request.getEmail())) {
            log.info("해당이메일이 이미 존재합니다");
            throw new InvalidUserInfoException(ErrorCode.ALREADY_REGISTERED_USER);
        }

        String encodePassword = passwordEncoder.encode(request.getPassword());

        Customer customer = new Customer(request.getName(), request.getEmail(), encodePassword);

        Customer saveCustomer = repository.save(customer);

        log.info("회원가입이 완료되었습니다");

        return new CustomerResponse(saveCustomer);
    }


    public Long login(String email, String password) {

        log.info("서비스가 호출되었습니다");

        Customer customer = repository.findCustomerByEmail(email)
                .orElseThrow(() -> new InvalidUserInfoException(ErrorCode.NULL_POINT_CUSTOMER));

        log.info("이메일이 일치합니다");

        if (passwordEncoder.matches(password, customer.getPassword())) {
            throw new InvalidUserInfoException(ErrorCode.INCORRECT_EMAIL_OR_PASSWORD);
        }

        log.info("비밀번호가 일치합니다");

        return customer.getId();
    }


    public void secession(Long customerId, CustomerSecessionRequest request){

        log.info("서비스가 호출되었습니다");

        Customer customer = repository.findById(customerId)//해당 회원이 존재하는지 확인후에 존재하지 않으면 예외를 발생시킨다
                .orElseThrow(()->new InvalidUserInfoException(ErrorCode.NULL_POINT_CUSTOMER));

        if(!customer.getPassword().equals(request.getPassword())){//비밀번호가 일치하지 않으면 예외를 발생시킨다
            log.info("입력비밀번호: "+ request.getPassword());
            log.info("db비밀번호: "+ customer.getPassword());
            throw new InvalidUserInfoException(ErrorCode.DISCREPANCIES_PASSWORD);
        }

        repository.deleteById(customerId);
        log.info("회원탈퇴 되었습니다");
    }
}
