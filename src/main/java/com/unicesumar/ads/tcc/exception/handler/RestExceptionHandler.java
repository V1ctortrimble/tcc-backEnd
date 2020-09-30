package com.unicesumar.ads.tcc.exception.handler;


import com.unicesumar.ads.tcc.exception.ErrorDetatils;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpForbiddenException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpNotFoundException.class)
    public ResponseEntity<?> handlerHttpNotFoundException(HttpNotFoundException hnfException) {
        ErrorDetatils details = ErrorDetatils.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(hnfException.getMessage())
                .build();
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpBadRequestException.class)
    public ResponseEntity<?> handlerHttpBadRequestException(HttpBadRequestException hbrException) {
        ErrorDetatils details = ErrorDetatils.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(hbrException.getMessage())
                .build();
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpForbiddenException.class)
    public ResponseEntity<?> handlerHttpForbiddenException(HttpForbiddenException hfException) {
        ErrorDetatils details = ErrorDetatils.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.FORBIDDEN.value())
                .error(HttpStatus.FORBIDDEN.getReasonPhrase())
                .message(hfException.getMessage())
                .build();
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        ErrorDetatils details = ErrorDetatils.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message("Internal Exception")
                .details(ex.getMessage())
                .build();
        return new ResponseEntity<>(details, headers, status);
    }
}
