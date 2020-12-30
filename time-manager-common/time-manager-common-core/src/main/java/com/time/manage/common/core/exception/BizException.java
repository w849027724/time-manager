package com.time.manage.common.core.exception;

import com.time.manage.common.core.enums.ErrorCodeEnum;

/**
 * @author wlj
 **/
public class BizException extends RuntimeException {

    private int code = ErrorCodeEnum.FAIL.getCode();

    public BizException(String msg) {
        super(msg);
    }

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public BizException(int code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
    }

    public BizException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public BizException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
