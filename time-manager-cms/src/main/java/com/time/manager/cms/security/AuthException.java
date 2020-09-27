package com.time.manager.cms.security;

import com.time.manage.common.core.enums.ErrorCodeEnum;

/**
 * @author wlj
 **/
public class AuthException extends RuntimeException {

    private int code = ErrorCodeEnum.UNAUTHORIZED.getCode();

    public AuthException(String msg) {
        super(msg);
    }

    public AuthException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public AuthException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public AuthException(int code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
    }

    public AuthException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public AuthException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public int getCode() {
        return code;
    }
}
