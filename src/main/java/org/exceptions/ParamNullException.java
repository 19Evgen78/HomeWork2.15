package org.exceptions;

public class ParamNullException extends RuntimeException {
    private static final String MESSAGE = "Попытка передать null";
    public ParamNullException() {
        super(MESSAGE);
    }
}
