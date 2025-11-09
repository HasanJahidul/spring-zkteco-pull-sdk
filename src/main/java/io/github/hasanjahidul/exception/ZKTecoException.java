package io.github.hasanjahidul.exception;

/**
 * Base exception for ZKTeco SDK operations
 */
public class ZKTecoException extends RuntimeException {

    public ZKTecoException(String message) {
        super(message);
    }

    public ZKTecoException(String message, Throwable cause) {
        super(message, cause);
    }
}
