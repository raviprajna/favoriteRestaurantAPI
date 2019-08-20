package com.ravi.labs.restaurant.dao;

import com.ravi.labs.restaurant.entity.restaurant.RestaurantEntity;
import com.ravi.labs.restaurant.enums.FoodType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Database Access Object for car table.
 * <p/>
 */
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {

    List<RestaurantEntity> findByFoodTypeAndDeleted(FoodType foodType, boolean deleted);

    Optional<RestaurantEntity> findByIdAndDeleted(Long restaurantId, boolean deleted);
}
