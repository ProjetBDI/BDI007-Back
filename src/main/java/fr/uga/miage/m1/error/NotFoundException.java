package fr.uga.miage.m1.error;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String resourceName;
    private final String fieldName;
    private final transient Object fieldValue;  // Mark fieldValue as transient

    public NotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
