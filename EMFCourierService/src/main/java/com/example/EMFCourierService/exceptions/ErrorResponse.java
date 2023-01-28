package com.example.EMFCourierService.exceptions;

public class ErrorResponse {

    public String status;
    public String message;
    Object trace;

    public ErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(String status, String message, Object trace) {
        this.status = status;
        this.message = message;
        this.trace = trace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getTrace() {
        return trace;
    }

    public void setTrace(Object trace) {
        this.trace = trace;
    }
}

