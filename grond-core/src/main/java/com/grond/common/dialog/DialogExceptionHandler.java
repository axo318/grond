package com.grond.common.dialog;

import com.grond.common.exception.ErrorCode;
import com.grond.common.exception.ServiceException;
import org.springframework.web.client.HttpServerErrorException;
import java.util.concurrent.Callable;

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
        } catch (HttpServerErrorException e) {
            throw chainExternalException(e);
        } catch (Exception e) {
            throw toServiceException(e);
        }
    }

    private static ServiceException chainExternalException(HttpServerErrorException e) {
        ServiceException parsedException = e.getResponseBodyAs(ServiceException.class);
        return new ServiceException("Dialog operation failed", ErrorCode.EXTERNAL, parsedException);
    }

    public static ServiceException toServiceException(RuntimeException e) {
        return new ServiceException(e.getMessage(), ErrorCode.INTERNAL, e);
    }

    public static ServiceException toServiceException(Exception e) {
        if (e instanceof ServiceException) {
            return (ServiceException) e;
        } else {
            return new ServiceException(e.getMessage(), ErrorCode.INTERNAL, e);
        }
    }
}
