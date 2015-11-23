package com.mycompany.services;

import com.mycompany.Repositories.ApiLinkRepository;
import com.mycompany.Repositories.CustomerRepository;
import com.mycompany.entities.ApiLink;
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

public class ApiLinkService {
    @Autowired
    private ApiLinkRepository apiLinkDAO;

    public ApiLink saveApiLink(ApiLink apiLink) {
        return apiLinkDAO.save(apiLink);
    }

    public Collection<ApiLink> findAll() {
        return apiLinkDAO.findAll();
    }

    public ApiLink findOne(Integer apiLinkId) {
        return apiLinkDAO.findOne(apiLinkId);
    }

    public ApiLink create(ApiLink apiLink) {
        return apiLinkDAO.save(apiLink);
    }

    public void delete(Integer id) {
        apiLinkDAO.delete(id);
    }
}
