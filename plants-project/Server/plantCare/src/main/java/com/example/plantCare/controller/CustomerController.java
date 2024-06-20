package com.example.plantCare.controller;

import com.example.plantCare.dao.CustomerDao;
import com.example.plantCare.model.Customer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "customers")
@PreAuthorize("permitAll()")

public class CustomerController {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Customer> getCustomers(){
        return customerDao.getCustomers();
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String testEndpoint() {
        return "Endpoint is working";
    }
}
