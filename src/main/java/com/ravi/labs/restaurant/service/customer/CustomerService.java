package com.ravi.labs.restaurant.service.customer;

import com.ravi.labs.restaurant.entity.customer.CustomerEntity;
import com.ravi.labs.restaurant.exception.EntityNotFoundException;
import com.ravi.labs.restaurant.dto.CustomerDTO;
import com.ravi.labs.restaurant.exception.ConstraintsViolationException;

import java.util.List;

public interface CustomerService {

    CustomerEntity find(Long customerId) throws EntityNotFoundException;

    CustomerEntity create(CustomerEntity customerDO) throws ConstraintsViolationException;

    void delete(Long customerId) throws EntityNotFoundException;

    List<CustomerEntity> find(CustomerDTO customerDTO);

}
