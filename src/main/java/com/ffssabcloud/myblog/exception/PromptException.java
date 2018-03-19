package com.ffssabcloud.myblog.exception;

public class PromptException extends RuntimeException{

    public PromptException() {}
    
    public PromptException(String message) {
        super(message);
    }
    
    public PromptException(Throwable cause) {
        super(cause);
    }
    
    public PromptException(String message, Throwable cause) {
        super(message, cause);
    }
}
