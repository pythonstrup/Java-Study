package com.test.exception;

public class BadCalculatingRequestException extends RuntimeException{

  public BadCalculatingRequestException() {
    super("Invalid input size, you must input 3 length");
  }
}
