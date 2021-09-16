package com.demo.myfileupload.excpetion;

public class NoFileFoundException extends Exception{
    public NoFileFoundException(String errorMessage) {
        super(errorMessage);
    }
}
