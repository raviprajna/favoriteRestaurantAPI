package com.ravi.labs.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Car select/unselect exceptions")
public class RestaurantException extends Exception {
    static final long serialVersionUID = -3387516993334229948L;


    public RestaurantException(String message) {
        super(message);
    }

}