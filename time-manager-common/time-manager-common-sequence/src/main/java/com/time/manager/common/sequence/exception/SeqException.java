package com.time.manager.common.sequence.exception;


import com.time.manage.common.core.exception.BizException;

public class SeqException extends BizException {
    public SeqException(String msg) {
        super(msg);
    }

    public SeqException(Throwable cause) {
        super(cause);
    }
}
