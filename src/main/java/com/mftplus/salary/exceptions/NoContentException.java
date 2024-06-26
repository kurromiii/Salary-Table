package com.mftplus.salary.exceptions;

public class NoContentException extends Exception{

    private String message;

    public NoContentException() {
        message = "No Content Found";
    }

    public NoContentException(String message) {
        super(message);
        this.message = message;
    }

    public int responseStatus(){
        return 204;
    }

}
