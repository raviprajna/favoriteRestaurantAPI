package com.ravi.labs.restaurant.dao;

import com.ravi.labs.restaurant.entity.customer.CustomerEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByIdAndDeleted(Long id, Boolean deleted);
}
