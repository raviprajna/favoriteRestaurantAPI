package com.ravi.labs.restaurant.controller;

import com.ravi.labs.restaurant.controller.mapper.RestaurantMapper;
import com.ravi.labs.restaurant.dto.RestaurantDTO;
import com.ravi.labs.restaurant.entity.restaurant.RestaurantEntity;
import com.ravi.labs.restaurant.enums.FoodType;
import com.ravi.labs.restaurant.exception.ConstraintsViolationException;
import com.ravi.labs.restaurant.exception.EntityNotFoundException;
import com.ravi.labs.restaurant.service.restaurant.RestaurantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ApiOperation(value = "Find Restaurants by Food type", position = 1)
    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> findRestaurants(@RequestParam FoodType foodType) {
        return ResponseEntity.ok(RestaurantMapper.makeRestaurantDTOList(restaurantService.find(foodType)));
    }

    @ApiOperation(value = "Find Restaurants by ID", position = 2)
    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable long restaurantId) throws EntityNotFoundException {

        RestaurantEntity restaurantDO = restaurantService.find(restaurantId);
        return ResponseEntity.ok(RestaurantMapper.makeRestaurantDTO(restaurantDO));
    }

    @ApiOperation(value = "Add Restaurant", position = 3)
    @PostMapping
    public ResponseEntity<RestaurantDTO> createRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO) throws ConstraintsViolationException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RestaurantMapper.makeRestaurantDTO(restaurantService.create(restaurantDTO)));
    }

    @ApiOperation(value = "Update restaurant details", position = 4)
    @PatchMapping
    public void updateRestaurantDetails(@Valid @RequestBody RestaurantDTO restaurantDTO)
            throws EntityNotFoundException, ConstraintsViolationException {
        restaurantService.updateRestaurantDetails(restaurantDTO);
    }

    @ApiOperation(value = "Soft Delete restaurant", position = 5)
    @DeleteMapping("/{restaurantId}")
    public void deleteRestaurant(@PathVariable long restaurantId) throws EntityNotFoundException {
        restaurantService.delete(restaurantId);
    }
}
