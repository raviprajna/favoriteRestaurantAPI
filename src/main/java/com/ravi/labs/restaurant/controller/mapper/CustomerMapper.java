package com.ravi.labs.restaurant.controller.mapper;

import com.ravi.labs.restaurant.dto.CustomerDTO;
import com.ravi.labs.restaurant.dto.RestaurantDTO;
import com.ravi.labs.restaurant.entity.customer.CustomerEntity;
import com.ravi.labs.restaurant.entity.restaurant.RestaurantEntity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerEntity makeCustomerEntity(CustomerDTO customerDTO) {
        CustomerEntity.CustomerEntityBuilder customerEntityBuilder =
                CustomerEntity.builder()
                .username(customerDTO.getUsername());

        Set<RestaurantDTO> restaurantsDTO = customerDTO.getRestaurants();
        if(null != restaurantsDTO)
        {
             // customerEntityBuilder.restaurants(RestaurantMapper.makeRestaurantsDTO(restaurantsDTO));
        }

        return customerEntityBuilder.build();
    }


    public static CustomerDTO makeCustomerDTO(CustomerEntity customerDO) {
        CustomerDTO.CustomerDTOBuilder customerDTOBuilder = CustomerDTO.builder()
                .id(customerDO.getId())
                .username(customerDO.getUsername())
                .deleted(customerDO.getDeleted());

        Set<RestaurantEntity> restaurants = customerDO.getRestaurants();
        if(null != restaurants)
        {
           // customerDTOBuilder.restaurants(RestaurantMapper.makeRestaurantDTO(restaurants));
        }
        return customerDTOBuilder.build();
    }


    public static List<CustomerDTO> makeCustomerDTOList(Collection<CustomerEntity> customers) {
        return customers.stream()
                .map(CustomerMapper::makeCustomerDTO)
                .collect(Collectors.toList());
    }
}
