package com.babo.bmbtrasporti.viafa.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public ApiErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
