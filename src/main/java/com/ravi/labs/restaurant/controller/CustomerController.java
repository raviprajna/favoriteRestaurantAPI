package com.ravi.labs.restaurant.controller;

import com.ravi.labs.restaurant.controller.mapper.CustomerMapper;
import com.ravi.labs.restaurant.dto.CustomerDTO;
import com.ravi.labs.restaurant.entity.customer.CustomerEntity;
import com.ravi.labs.restaurant.exception.ConstraintsViolationException;
import com.ravi.labs.restaurant.exception.EntityNotFoundException;
import com.ravi.labs.restaurant.service.customer.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * All operations with a customer will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "Fetch customers based on criteria object in the POST body", position = 1)
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/fetchCustomers")
    public List<CustomerDTO> filterCustomers(@Valid @RequestBody CustomerDTO customerDTO) {

        return CustomerMapper.makeCustomerDTOList(customerService.find(customerDTO));
    }

    @ApiOperation(value = "Find Customers by ID", position = 2)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable long customerId) throws EntityNotFoundException {

        CustomerEntity customerDO = customerService.find(customerId);
        return CustomerMapper.makeCustomerDTO(customerDO);
    }

    @ApiOperation(value = "Add Customer", position = 3)
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws ConstraintsViolationException {
        CustomerEntity customerDO = CustomerMapper.makeCustomerEntity(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomerMapper.makeCustomerDTO(customerService.create(customerDO)));
    }


    @ApiOperation(value = "Soft Delete customer", position = 4)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable long customerId) throws EntityNotFoundException {
        customerService.delete(customerId);
    }

}
