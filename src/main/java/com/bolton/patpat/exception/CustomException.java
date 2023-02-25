package com.bolton.patpat.exception;

public class CustomException extends RuntimeException {

    private int status;
    private String message;

    public CustomException(int status, String message){
        super(message);
        this.status = status;
        this.message = message;
    }

    int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
