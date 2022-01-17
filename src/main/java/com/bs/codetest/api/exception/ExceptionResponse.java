package com.bs.codetest.api.exception;

import java.util.Date;

public class ExceptionResponse {

  private String message;
  private String details;
  private int status;

  public ExceptionResponse(Date timestamp, String message, String details, int status) {
    super();
    this.message = message;
    this.details = details;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }

  public int getStatus() {
    return status;
  }

}