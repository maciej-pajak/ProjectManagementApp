package pl.maciejpajak.util;

public class BaseEntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8629853900444844752L;
    
    private static final String MESSAGE_PATTERN = "Entity with id %s can not be found";

    public BaseEntityNotFoundException(Long id) {
        super(String.format(MESSAGE_PATTERN, id));

    }

    public BaseEntityNotFoundException(String message) {
        super(message);
    }

}
