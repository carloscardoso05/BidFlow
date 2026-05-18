package io.github.carloscardoso05.bidflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
