package com.grond.common.dialog;

import com.grond.common.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Controller {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        ServiceException serviceException = DialogExceptionHandler.toServiceException(e);
        return handleServiceException(serviceException);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException e) {
        return ResponseEntity.status(e.getErrorCode().toHttpStatus()).body(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e) {
        ServiceException serviceException = DialogExceptionHandler.toServiceException(e);
        return handleServiceException(serviceException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        ServiceException serviceException = DialogExceptionHandler.toServiceException(e);
        return handleServiceException(serviceException);
    }
}