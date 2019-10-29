package com.example.heart.imagehosting.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: MyExceptionHandler
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/10/29 17:31
 * @Version: v1.0
 */
@RestControllerAdvice
public class MyExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    public Object exceptionHandle(Exception e) {
        logger.error("exception :{}", e.getMessage());
        return null;
    }
}
