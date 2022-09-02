package com.imooc.reader.exception;

/**
 * @ClassName: MemberException
 * @Description: 自定义会员类异常
 * @author: XU
 * @date: 2022年09月02日 15:22
 **/

public class MemberException extends RuntimeException {
    public MemberException(String message) {
        super(message);
    }
}
