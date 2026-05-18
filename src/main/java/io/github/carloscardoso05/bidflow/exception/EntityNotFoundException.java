package io.github.carloscardoso05.bidflow.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> clazz, Object id) {
        super(String.format("%s with id %s not found", clazz.getSimpleName(), id));
    }

    public EntityNotFoundException(Class<?> clazz, String key, Object id) {
        super(String.format("%s with %s %s not found", clazz.getSimpleName(), key, id));
    }
}
