package com.ravi.labs.restaurant.service.restaurant;

import com.ravi.labs.restaurant.entity.restaurant.RestaurantEntity;
import com.ravi.labs.restaurant.dto.RestaurantDTO;
import com.ravi.labs.restaurant.enums.FoodType;
import com.ravi.labs.restaurant.exception.ConstraintsViolationException;
import com.ravi.labs.restaurant.exception.EntityNotFoundException;

import java.util.List;

public interface RestaurantService {

    RestaurantEntity find(Long restaurantId) throws EntityNotFoundException;

    RestaurantEntity create(RestaurantDTO restaurantDTO) throws ConstraintsViolationException;

    void delete(Long restaurantId) throws EntityNotFoundException;

    void updateRestaurantDetails(RestaurantDTO restaurantDTO) throws EntityNotFoundException, ConstraintsViolationException;

    List<RestaurantEntity> find(FoodType foodType);
}
