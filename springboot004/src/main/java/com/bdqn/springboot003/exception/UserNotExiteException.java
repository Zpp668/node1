package com.bdqn.springboot003.exception;

public class UserNotExiteException extends RuntimeException{
    public UserNotExiteException() {
        super("用户不存在");
    }
}
