package com.example.CalendarProject.Common.Handler;

import com.example.CalendarProject.Comment.Exception.CommentNullException;
import com.example.CalendarProject.Event.Exception.EventNullException;
import com.example.CalendarProject.Customer.Exception.InvalidCustomerInfoException;
import com.example.CalendarProject.Common.Messageresponse.ExceptionMessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCustomerInfoException.class)
    public ResponseEntity<ExceptionMessageResponse> handleUserInfoException(InvalidCustomerInfoException ex) {

        ExceptionMessageResponse response = new ExceptionMessageResponse(ex.getStatus(), ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(EventNullException.class)
    public ResponseEntity<ExceptionMessageResponse> handleEventNullException(EventNullException ex) {
        ExceptionMessageResponse response = new ExceptionMessageResponse(ex.getStatus(), ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(CommentNullException.class)
    public ResponseEntity<ExceptionMessageResponse> handleCommentNullException(CommentNullException ex) {
        ExceptionMessageResponse response = new ExceptionMessageResponse(ex.getStatus(), ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //MethodArgumentNotValidException은 항상 상태코드로 BAD_REQUEST이기 때문에 STATUS를 400으로 설정
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionMessageResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();

        List<ExceptionMessageResponse> responses = new ArrayList<>();

        for(FieldError fieldError : result.getFieldErrors()){
            ExceptionMessageResponse response = new ExceptionMessageResponse(400,"ERR006", fieldError.getDefaultMessage());
            responses.add(response);
        }


        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}