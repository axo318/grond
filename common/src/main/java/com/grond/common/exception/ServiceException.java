package com.grond.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Nonnull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceException extends RuntimeException {
    @JsonProperty("detail-message")
    private String detailMessage;
    @JsonProperty("error-code")
    private ErrorCode errorCode;

    public ServiceException(String message, @Nonnull ErrorCode errorCode) {
        super(message);
        this.detailMessage = message;
        this.errorCode = errorCode;
    }

    public ServiceException(String message, @Nonnull ErrorCode errorCode, Throwable cause) {
        super(message, cause);
        this.detailMessage = message;
        this.errorCode = errorCode;
    }

    @Nonnull
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        String message = detailMessage;
        if (message == null) {
            message = "";
        }
        return String.format("ServiceException [%s] %s", errorCode, message);
    }
}
