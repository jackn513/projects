package org.example.music2.dao.Customer;

import org.example.music2.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer getCustomerById(int customerId);
    List<Customer> getCustomers();
    Customer createCustomer(Customer newCustomer);
    int deleteCustomerById(int customerId);
}
