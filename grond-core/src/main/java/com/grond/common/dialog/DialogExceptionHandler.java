package com.grond.common.dialog;

import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import java.util.concurrent.Callable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

public class DialogExceptionHandler {

    public static <T> T safeWrap(Callable<T> callable) {
        return safeWrapCommon(callable);
    }

    public static void safeWrap(Runnable runnable) {
        safeWrapCommon(() -> {
            runnable.run();
            return null;
        });
    }

    private static <T> T safeWrapCommon(Callable<T> callable) {
        try {
            return callable.call();
        } catch (HttpClientErrorException e) {
            throw new ServiceException("Dialog operation failed", ErrorCode.INVALID_REQUEST, e);
        } catch (HttpServerErrorException | ResourceAccessException e) {
            throw new ServiceException("Dialog operation failed", ErrorCode.EXTERNAL, e);
        } catch (Exception e) {
            throw new ServiceException("Dialog operation failed", ErrorCode.INTERNAL, e);
        }
    }

    public static ServiceException toServiceException(RuntimeException e) {
        return new ServiceException(e.getMessage(), ErrorCode.INTERNAL, e);
    }

    public static ServiceException toServiceException(HttpMessageNotReadableException e) {
        return new ServiceException(e.getMessage(), ErrorCode.INVALID_REQUEST, e);
    }

    public static ServiceException toServiceException(Exception e) {
        if (e instanceof ServiceException) {
            return (ServiceException) e;
        } else {
            return new ServiceException(e.getMessage(), ErrorCode.INTERNAL, e);
        }
    }
}
