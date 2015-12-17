package com.mycompany.Repositories;

import com.mycompany.entities.ApiLink;
import com.mycompany.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mantou on 11/21/2015.
 */
@Repository
public interface ApiLinkRepository extends JpaRepository<ApiLink, Integer> {

}