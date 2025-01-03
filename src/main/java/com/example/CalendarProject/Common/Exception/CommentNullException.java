package com.example.CalendarProject.Common.Exception;

import com.example.CalendarProject.Common.Code.ErrorCode;
import lombok.Getter;

@Getter
public class CommentNullException extends RuntimeException {
  private int status;
  private String code;
  private String message;

  public CommentNullException(ErrorCode code) {
    this.code = code.getCode();
    this.status = code.getStatus();
    this.message = code.getMessage();
  }
}
