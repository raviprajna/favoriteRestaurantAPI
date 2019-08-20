package com.ravi.labs.restaurant.controller.mapper;

import com.ravi.labs.restaurant.dto.RestaurantDTO;
import com.ravi.labs.restaurant.entity.restaurant.RestaurantEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RestaurantMapper {
    public static RestaurantEntity makeRestaurantEntity(RestaurantDTO restaurantDTO) {

        return new RestaurantEntity(restaurantDTO.getName(),
                restaurantDTO.getFoodType(),
                restaurantDTO.getRating(),
                restaurantDTO.getGeoCoordinate(),
                restaurantDTO.getNoOfRooms(),
                restaurantDTO.getUsp()
        );
    }

    public static Set<RestaurantDTO> makeRestaurantsDTO(Set<RestaurantEntity> restaurants){
        return restaurants.stream().map(RestaurantMapper::makeRestaurantDTO).collect(Collectors.toSet());
    }

    public static RestaurantDTO makeRestaurantDTO(RestaurantEntity restaurantEntity) {
        RestaurantDTO.RestaurantDTOBuilder restaurantDTOBuilder = RestaurantDTO.builder()
                .id(restaurantEntity.getId())
                .name(restaurantEntity.getName())
                .rating(restaurantEntity.getRating())
                .noOfRooms(restaurantEntity.getNoOfRooms())
                .foodType(restaurantEntity.getFoodType())
                .usp(restaurantEntity.getUsp());

        RestaurantDTO restaurantDTO = restaurantDTOBuilder.build();
        return restaurantDTO;
    }

    public static List<RestaurantDTO> makeRestaurantDTOList(List<RestaurantEntity> restaurants) {
        return restaurants.stream()
                .map(RestaurantMapper::makeRestaurantDTO)
                .collect(Collectors.toList());
    }
}
