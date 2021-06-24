package com.spring.antsway.controller;

import java.util.List;
import java.util.Optional;

import com.spring.antsway.model.Customer;
import com.spring.antsway.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers") 
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerRepository.findAll();
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(customers, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/customers/{id}") 
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            if (customer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(customer.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/customers") 
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer saved_customer = customerRepository.save(
                new Customer(customer.getFirstname(), customer.getLastname(), customer.getAddress(), customer.getPhoneNumber())
            );
            return new ResponseEntity<>(saved_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customers/{id}") 
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        Optional<Customer> current_customer = customerRepository.findById(id);

        if (current_customer.isPresent()) {
            Customer new_customer = current_customer.get();
            new_customer.setFirstname(customer.getFirstname());
            new_customer.setLastname(customer.getLastname());
            new_customer.setAddress(customer.getAddress());
            new_customer.setPhoneNumber(customer.getPhoneNumber());
            return new ResponseEntity<>(customerRepository.save(new_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/customers/{id}") 
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
        try {
            Optional<Customer> current_customer = customerRepository.findById(id);
            if (current_customer.isPresent()) {
                customerRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
