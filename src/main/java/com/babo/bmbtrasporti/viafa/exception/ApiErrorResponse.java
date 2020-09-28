package com.babo.bmbtrasporti.viafa.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {

    private final int status;
    private final String message;
    private final long timeStamp;
}
