package com.karamanmert.user.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

    @JsonProperty("errors")
    private List<ErrorDetail> errors;
}