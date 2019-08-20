package com.ravi.labs.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.labs.restaurant.enums.FoodType;
import com.ravi.labs.restaurant.enums.GeoCoordinate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantDTO {

    private Long id;

    private String name;

    private FoodType foodType;

    private Float rating;

    private GeoCoordinate geoCoordinate;

    private Integer noOfRooms;

    private String usp;

}
