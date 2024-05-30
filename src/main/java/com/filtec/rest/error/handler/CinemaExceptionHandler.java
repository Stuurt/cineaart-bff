package com.filtec.rest.error.handler;

import com.filtec.rest.exception.FeignClientException;
import com.filtec.rest.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CinemaExceptionHandler {

    @ExceptionHandler({FeignClientException.class})
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(FeignClientException exception, WebRequest request) {
            return new ResponseEntity<>(exception.getErrorResponse(),
                    exception.getResponseStatus());
        }
}
