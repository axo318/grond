package com.grond.common.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrondLogger {

    private final Logger logger;

    private GrondLogger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public static GrondLogger getLogger(Class<?> clazz) {
        return new GrondLogger(clazz);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

}
