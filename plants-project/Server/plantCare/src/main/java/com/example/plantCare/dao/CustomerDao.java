package com.example.plantCare.dao;

import com.example.plantCare.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomers();
    Customer getCustomerById(int customerId);
    Customer getCustomerByName(String customerName);
    Customer getCustomerByEmail(String email);

    Customer createCustomer(Customer newCustomer);
    Customer updateCustomer(Customer updatedCustomer);
    Customer deleteCustomer(int customerId);

}
