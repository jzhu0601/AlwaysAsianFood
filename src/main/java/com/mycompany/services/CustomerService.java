package com.mycompany.services;

import com.mycompany.Repositories.CustomerRepository;
import com.mycompany.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Collection;

/**
 * Created by jzhu on 11/17/2015.
 */
@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerDAO;

    public Customer saveCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public Collection<Customer> findAll() {
        return customerDAO.findAll();
    }

    public Customer findOne(Integer customerId) {
        return customerDAO.findOne(customerId);
    }

    public Customer create(Customer customer) {
        return customerDAO.save(customer);
    }

    public Customer update(Customer customer) {

        Customer customerToUpdate = findOne(customer.getCustomerId());

        if (customerToUpdate == null) {
            throw new NoResultException("Requested entity not found.");
        }

        customerToUpdate.setCustomerFirstName(customer.getCustomerFirstName());
        customerToUpdate.setCustomerId(customer.getCustomerId());
        customerToUpdate.setCustomerLastName(customer.getCustomerLastName());
        customerToUpdate.setEmail(customer.getUsername());
        customerToUpdate.setUsername(customer.getUsername());
        customerToUpdate.setReviews(customer.getReviews());
        return customerDAO.save(customerToUpdate);

    }

    public void delete(Integer id) {
        customerDAO.delete(id);
    }
}
