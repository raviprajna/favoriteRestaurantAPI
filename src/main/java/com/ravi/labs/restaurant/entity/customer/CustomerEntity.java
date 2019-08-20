package com.ravi.labs.restaurant.entity.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ravi.labs.restaurant.entity.restaurant.RestaurantEntity;
import com.ravi.labs.restaurant.entity.abstractEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(
        name = "customer",
        uniqueConstraints = @UniqueConstraint(name = "uc_username", columnNames = {"username"})
)
public class CustomerEntity extends BaseEntity {

    @Column(nullable = false)
    @NotNull(message = "Customer name can not be null!")
    private String username;

    @JsonManagedReference
    @ManyToMany
    private Set<RestaurantEntity> restaurants;

    public CustomerEntity(){};

    public CustomerEntity(String username) {
        this.username = username;
    }
}
