package com.grond.common.dialog;

import com.grond.common.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Controller {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ServiceException> handleServiceException(ServiceException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceException> handleRuntimeException(RuntimeException e) {
        ServiceException serviceException = DialogExceptionHandler.toServiceException(e);
        return handleServiceException(serviceException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServiceException> handleException(Exception e) {
        ServiceException serviceException = DialogExceptionHandler.toServiceException(e);
        return handleServiceException(serviceException);
    }
}