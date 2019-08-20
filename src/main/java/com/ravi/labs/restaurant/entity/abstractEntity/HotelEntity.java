package com.ravi.labs.restaurant.entity.abstractEntity;

import com.ravi.labs.restaurant.enums.FoodType;
import com.ravi.labs.restaurant.enums.GeoCoordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class HotelEntity extends BaseEntity {

    @Column(nullable = false)
    @NotNull(message = "Hotel Name cannot be empty!")
    private String name;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    private Float rating;

    @Embedded
    private GeoCoordinate coordinate;


}

