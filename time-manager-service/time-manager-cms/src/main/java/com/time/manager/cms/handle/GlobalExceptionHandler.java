package com.time.manager.cms.handle;

import com.time.manage.common.core.exception.BizException;
import com.time.manage.common.core.utils.R;
import com.time.manager.cms.security.AuthException;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public R<String> dataAccessExceptionHandler(HttpServletRequest request, DataAccessException e) {
        log.error("服务器内部错误：数据库操作异常", e);
        return R.failed("服务器内部错误");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public R illegalArgumentExceptionHandler(HttpServletRequest request, IllegalArgumentException e) {
        log.error("非法参数异常", e);
        return R.failed(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R ValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("操作失败，业务异常", e);
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return R.failed("操作失败:" + objectError.getDefaultMessage());
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public R authExceptionHandler(HttpServletRequest request, AuthException e) {
        log.error("操作失败，业务异常", e);
        return R.failed(e.getCode(), "操作失败:" + e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public R bizExceptionHandler(HttpServletRequest request, BizException e) {
        log.error("操作失败，业务异常", e);
        return R.failed("操作失败:" + e.getMessage());
    }

    /**
     * 此异常必须放最后一个
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("未知错误", e);
        return R.failed("未知错误");
    }


}

