package com.mycompany.controllers;

import com.mycompany.entities.Customer;
import com.mycompany.entities.Restaurant;
import com.mycompany.services.CustomerService;
import com.mycompany.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by mantou on 11/20/2015.
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/api/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Customer>> getCustomers() {

        Collection<Customer> customers = customerService.findAll();

        return new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/customers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer customerId) {

        Customer customer = customerService.findOne(customerId);

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.create(customer);
        return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/customers/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody Customer customer) {

        Customer customer1 = customerService.update(customer);
        if (customer1 == null) {
            return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
        customerService.delete(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }


}
