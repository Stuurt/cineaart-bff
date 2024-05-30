package com.filtec.rest.exception;

import com.filtec.rest.error.ErrorResponse;
import org.springframework.http.HttpStatus;

public class FeignClientException extends Exception {
        private final String requestUrl;
        private final HttpStatus responseStatus;
        private final ErrorResponse errorResponse;

        public FeignClientException(String requestUrl, HttpStatus responseStatus, ErrorResponse errorResponse) {
            super(errorResponse.getMessage());
            this.requestUrl = requestUrl;
            this.responseStatus = responseStatus;
            this.errorResponse = errorResponse;
        }

        public String getRequestUrl() {
            return requestUrl;
        }

        public HttpStatus getResponseStatus() {
            return responseStatus;
        }

        public ErrorResponse getErrorResponse() {
            return errorResponse;
        }
    }