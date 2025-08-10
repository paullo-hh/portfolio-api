package com.portfolio.portfolio_api.exception;

public class ContactLimitExceededException extends RuntimeException {
  public ContactLimitExceededException(String message) {
    super(message);
  }
}
