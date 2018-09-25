package com.error;

public class AppException extends RuntimeException {
    private ExceptionType exceptionType;

    public AppException(ExceptionType exceptionType) {
        super();
        this.exceptionType = exceptionType;
    }
    public String getMsg(){
        return exceptionType.getMsg();
    }
    public int getCode(){
        return exceptionType.getCode();
    }
}
