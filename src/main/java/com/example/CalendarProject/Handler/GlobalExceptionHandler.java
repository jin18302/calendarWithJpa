package com.example.CalendarProject.Handler;

import com.example.CalendarProject.Common.Exception.CommentNullException;
import com.example.CalendarProject.Common.Exception.EventNullException;
import com.example.CalendarProject.Common.Exception.InvalidUserInfoException;
import com.example.CalendarProject.Messageresponse.ExceptionMessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserInfoException.class)
    public ResponseEntity<ExceptionMessageResponse> handleUserInfoException(InvalidUserInfoException ex) {

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


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ExceptionMessageResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//        ExceptionMessageResponse response = new ExceptionMessageResponse(ex., ex.getMessage());
//    }
}