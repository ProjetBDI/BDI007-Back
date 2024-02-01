package fr.uga.miage.m1.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
@Getter
public class NotEnoughtPlacesException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final transient Object fieldRequired;
    private final transient Object fieldValue;  // Mark fieldValue as transient

    public NotEnoughtPlacesException(String resourceName, String fieldName, Object fieldRequired, Object fieldValue) {
        super(String.format("%s , %s required '%s' but provide '%s'", resourceName, fieldName, fieldRequired, fieldValue));
        this.fieldRequired = fieldRequired;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}


