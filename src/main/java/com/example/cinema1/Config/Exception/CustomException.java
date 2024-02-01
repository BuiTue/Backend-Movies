package com.example.cinema1.Config.Exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@JsonIgnoreProperties({"stackTrace", "cause", "suppressed", "localizedMessage"})
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private Instant timestamp;
    private int status;
    private String message;
    private String path;


    public CustomException(int status, String message) {
        this.timestamp = Instant.now();
        this.status = status;
        this.message = message;
    }

    public CustomException(ErrorResponseEnum errorResponseEnum) {
        this.timestamp = Instant.now();
        this.status = errorResponseEnum.status;
        this.message = errorResponseEnum.message;
    }

    public CustomException(String errorMessage, int status, String path) {
        this.timestamp = Instant.now();
        this.status = status;
        this.path = path;
        this.message = errorMessage;
    }
}
