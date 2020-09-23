package com.unicesumar.ads.tcc.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
@AllArgsConstructor
public class HttpForbiddenException extends RuntimeException {
    public HttpForbiddenException(String message) {
        super(message);
    }
}
