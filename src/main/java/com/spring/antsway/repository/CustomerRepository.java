package com.spring.antsway.repository;

import com.spring.antsway.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // add unique search methods here (e.g. search by name)
}
