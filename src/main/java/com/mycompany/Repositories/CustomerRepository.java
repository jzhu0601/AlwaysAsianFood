package com.mycompany.Repositories;

import com.mycompany.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jzhu on 11/17/2015.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
