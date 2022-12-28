package com.profile.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter @Setter @AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    
	private static final long serialVersionUID = 5344320715962995240L;
    private final String resourceName;
	private final String fieldName;
	private final Object fieldValue;
}
