package com.filtec.rest.config.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filtec.rest.exception.FeignClientException;
import com.filtec.rest.error.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        String requestUrl = response.request().url();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        try {
            if (response.body() != null) {
                Map<String, Object> responseBodyMap = objectMapper.readValue(response.body().asInputStream(), Map.class);
                ErrorResponse errorResponse = new ErrorResponse();
                String errorMessage = responseBodyMap.get("message").toString();
                String code = responseBodyMap.get("code").toString();
                String timestamp = responseBodyMap.get("timestamp").toString();
                if (responseBodyMap.containsKey("details") && responseBodyMap.get("details") instanceof List) {
                    List<String> details = (List<String>) responseBodyMap.get("details");
                    errorResponse.setDetails(details);
                }
                errorResponse.setMessage(errorMessage);
                errorResponse.setCode(Integer.parseInt(code));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                errorResponse.setTimestamp(LocalDateTime.parse(timestamp, formatter));
                errorResponse.setPath(requestUrl);
                return new FeignClientException(requestUrl, responseStatus, errorResponse);
            } else {
                return new Exception("Empty response body");
            }
        } catch (Exception e) {
            return new Exception("Internal Server Error");
        }
    }
}
