package org.exceptions;

public class IndexNotFoundException extends RuntimeException {
    public static final String TEMPLATE_MESSAGE = "Элемента с индексом %d нет";
    public IndexNotFoundException(String message) {
        super(message);
    }
}
