package com.luv2code.demo.rest;

public class StudentErrorResponse {
    private int Status;
    private String message;
    private long timestamp;

    public StudentErrorResponse(){

    }


    public StudentErrorResponse(int status, String message, long timestamp) {
        Status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}