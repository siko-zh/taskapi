package com.zholdigaliev.taskapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorResponse {
    private int status;
    private String error;
    private String message;
    private String path;
    private Map<String, String> fieldErrors;
}
