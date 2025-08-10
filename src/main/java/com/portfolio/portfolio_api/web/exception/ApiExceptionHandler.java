package com.portfolio.portfolio_api.web.exception;

import com.portfolio.portfolio_api.exception.ContactLimitExceededException;
import com.portfolio.portfolio_api.exception.EmailAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> MethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                      HttpServletRequest httpServletRequest,
                                                                      BindingResult bindingResult) {
    log.error("API ERROR: ", exception);
    return ResponseEntity
        .status(HttpStatus.UNPROCESSABLE_ENTITY)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            new ErrorMessage(
                httpServletRequest,
                HttpStatus.UNPROCESSABLE_ENTITY,
                "Campo(s) inválido(s).",
                bindingResult
            )
        );
  }

  @ExceptionHandler(EmailAlreadyExistsException.class)
  public ResponseEntity<ErrorMessage> handleEmailAlreadyExists(EmailAlreadyExistsException exception,
                                                               HttpServletRequest httpServletRequest) {
    log.error("API ERROR: ", exception);
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            new ErrorMessage(
                httpServletRequest,
                HttpStatus.CONFLICT,
                exception.getMessage()
            )
        );
  }

  @ExceptionHandler(ContactLimitExceededException.class)
  public ResponseEntity<ErrorMessage> handleContactLimitExceeded(ContactLimitExceededException exception,
                                                                 HttpServletRequest httpServletRequest) {
    log.error("API ERROR: ", exception);
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            new ErrorMessage(
                httpServletRequest,
                HttpStatus.CONFLICT,
                exception.getMessage()
            )
        );
  }
}