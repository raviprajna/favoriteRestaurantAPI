package com.ravi.labs.restaurant.entity.restaurant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ravi.labs.restaurant.entity.abstractEntity.HotelEntity;
import com.ravi.labs.restaurant.entity.customer.CustomerEntity;
import com.ravi.labs.restaurant.enums.FoodType;
import com.ravi.labs.restaurant.enums.GeoCoordinate;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "restaurant", uniqueConstraints = {
        @UniqueConstraint(name = "uc_name", columnNames = {"name"})
})
public class RestaurantEntity extends HotelEntity {

    private Integer noOfRooms;

    private String usp;

    @JsonIgnore
    @JsonBackReference
    @ManyToMany
    private Set<CustomerEntity> customers;

    public RestaurantEntity(String name,
                            FoodType foodType,
                            Float rating,
                            GeoCoordinate geoCoordinate,
                            Integer noOfRooms,
                            String usp) {
        super(name, foodType, rating, geoCoordinate);
        this.noOfRooms = noOfRooms;
        this.usp = usp;
    }
}
