package fr.uga.miage.m1.error;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class NotFoundException  extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public NotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}