package com.ravi.labs.restaurant.service.restaurant;

import com.ravi.labs.restaurant.dao.RestaurantRepository;
import com.ravi.labs.restaurant.entity.restaurant.RestaurantEntity;
import com.ravi.labs.restaurant.controller.mapper.RestaurantMapper;
import com.ravi.labs.restaurant.dto.RestaurantDTO;
import com.ravi.labs.restaurant.enums.FoodType;
import com.ravi.labs.restaurant.exception.ConstraintsViolationException;
import com.ravi.labs.restaurant.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    /**
     * Selects a Restaurant by id.
     *
     * @param RestaurantId
     * @return found Restaurant
     * @throws EntityNotFoundException if no Restaurant with the given id was found.
     */
    @Override
    public RestaurantEntity find(Long RestaurantId) throws EntityNotFoundException {
        return findRestaurantChecked(RestaurantId);
    }


    /**
     * Creates a new Restaurant.
     *
     * @param restaurantDTO
     * @return
     * @throws ConstraintsViolationException if a Restaurant already exists with the given username, ... .
     */
    @Override
    public RestaurantEntity create(RestaurantDTO restaurantDTO) throws ConstraintsViolationException {
        RestaurantEntity restaurant = RestaurantMapper.makeRestaurantEntity(restaurantDTO);

        try {
            RestaurantEntity restaurantDO = restaurantRepository.save(restaurant);
            return restaurantDO;
        } catch (DataIntegrityViolationException e) {
            log.warn("ConstraintsViolationException while creating a Restaurant: {}", restaurantDTO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }

    }


    /**
     * Deletes an existing Restaurant by id.
     *
     * @param RestaurantId
     * @throws EntityNotFoundException if no Restaurant with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long RestaurantId) throws EntityNotFoundException {
        RestaurantEntity RestaurantDO = findRestaurantChecked(RestaurantId);
        RestaurantDO.setDeleted(true);
    }


    /**
     * Update the location for a Restaurant.
     *
     * @param restaurantDTO
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateRestaurantDetails(RestaurantDTO restaurantDTO) throws EntityNotFoundException, ConstraintsViolationException {

        RestaurantEntity restaurantDO = findRestaurantChecked(restaurantDTO.getId());
        try {

            BeanUtils.copyProperties(restaurantDTO, restaurantDO);
        } catch (DataIntegrityViolationException e) {
            log.warn("ConstraintsViolationException while creating a Restaurant: {}", restaurantDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }

    }


    /**
     * Find all Restaurants by online state.
     *
     * @param foodType
     */
    @Override
    public List<RestaurantEntity> find(FoodType foodType) {
        return restaurantRepository.findByFoodTypeAndDeleted(foodType, false);
    }


    private RestaurantEntity findRestaurantChecked(Long restaurantId) throws EntityNotFoundException {
        return restaurantRepository.findByIdAndDeleted(restaurantId, false)
                .orElseThrow(() -> new EntityNotFoundException("Could not find Restaurant with id: " + restaurantId));
    }
}
