package com.lujiahao.exception;

/**
 * 自定义连接异常
 * Created by lujiahao on 2016/7/5.
 */
public class MyConnectionException extends RuntimeException {
    public MyConnectionException() {
        super();
    }

    public MyConnectionException(String message) {
        super(message);
    }

    public MyConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyConnectionException(Throwable cause) {
        super(cause);
    }

    protected MyConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
