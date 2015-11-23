package com.mycompany.controllers;

import com.mycompany.entities.Customer;
import com.mycompany.entities.Restaurant;
import com.mycompany.entities.ApiLink;
import com.mycompany.services.CustomerService;
import com.mycompany.services.CustomerService;
import com.mycompany.services.ApiLinkService;
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
public class ApiLinkController {

    @Autowired
    private ApiLinkService apiLinkService;

    @RequestMapping(value = "/api/apiLinks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ApiLink>> getCustomers() {

        Collection<ApiLink> apiLinks = apiLinkService.findAll();

        return new ResponseEntity<Collection<ApiLink>>(apiLinks, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/apiLinks/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiLink> getApiLink(@PathVariable("id") Integer apiLinkId) {

        ApiLink review = apiLinkService.findOne(apiLinkId);

        return new ResponseEntity<ApiLink>(review, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/apiLinks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiLink> createApiLink(@RequestBody ApiLink apiLink) {
        ApiLink apiLink1 = apiLinkService.create(apiLink);
        return new ResponseEntity<ApiLink>(apiLink1, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/api/apiLinks/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ApiLink> deleteApiLink(@PathVariable("id") Integer id) {
        apiLinkService.delete(id);
        return new ResponseEntity<ApiLink>(HttpStatus.NO_CONTENT);
    }


}
