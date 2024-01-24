package org.example.dao;

import org.example.music2.dao.Customer.JdbcCustomerDao;
import org.example.music2.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JdbcCustomerDaoTests extends BaseDaoTests {

    private static final Customer CUSTOMER_1 = new Customer (1, "Customer 1",
        "Address 1", "123-555-1234",
        "email1@email.com", LocalDate.parse("1992-03-18")
    );
    private static final Customer CUSTOMER_2 = new Customer(2, "Customer 2",
            "Address 2", "123-555-2345",
            "email2@email.com", LocalDate.parse("1988-07-25")
    );
    private static final Customer CUSTOMER_3 = new Customer(3,"Customer 3",
            "Address 3", "123-555-9876",
            "email3@email.com", LocalDate.parse("2000-12-05")
    );

    private JdbcCustomerDao dao;

    @Before
    public void setup() {
        dao = new JdbcCustomerDao(dataSource);
    }
    @Test
    public void getCustomerById_with_valid_id_returns_correct_customer(){
        // 1 //
        Customer customer = dao.getCustomerById(CUSTOMER_1.getCustomerId());
        assertNotNull("getCustomerById(1) returned a null customer", customer);
        assertCustomersMatch("getCustomerById(1) returned incorrect Customer", CUSTOMER_1, customer);

        // 2//
        customer = dao.getCustomerById(CUSTOMER_2.getCustomerId());
        assertNotNull("getCustomerById(2) returned a null customer", customer);
        assertCustomersMatch("getCustomerById(2) returned incorrect Customer", CUSTOMER_2, customer);

        // 3 //
        customer = dao.getCustomerById(CUSTOMER_3.getCustomerId());
        assertNotNull("getCustomerById(3) returned a null customer", customer);
        assertCustomersMatch("getCustomerById(3) returned incorrect Customer", CUSTOMER_3, customer);

    }

    @Test
    public void getCustomerById_with_invalid_id_returns_null_customer() {
        Customer customer = dao.getCustomerById(0);
        Assert.assertNull("getCustomerById(0) does not exist", customer);

        customer = dao.getCustomerById(5);
        Assert.assertNull("getCustomerById(5) does not exist", customer);

        customer = dao.getCustomerById(6);
        Assert.assertNull("getCustomerById(6) does not exist", customer);
    }

    @Test
    public void getCustomers() {
        List<Customer> customers = dao.getCustomers();
        Assert.assertNotNull("getCustomers returned a null List of customers", customers);
        Assert.assertEquals("getCustomers returned the wrong number of customers in the list",
                3, customers.size());
    }
    @Test
    public void createCustomer_creates_customer(){
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("name test");
        newCustomer.setStreetAddress("street address 1 test");
        newCustomer.setPhoneNumber("phone_number");
        newCustomer.setEmail("email test");
        newCustomer.setDateOfBirth(LocalDate.parse("2000-01-01"));


        Customer createdCustomer = dao.createCustomer(newCustomer);
        Assert.assertNotNull("createCustomer returned a null customer", createdCustomer);
        Assert.assertTrue("createCustomer did not return a customer with id set.",
                createdCustomer.getCustomerId() > 0);
        Assert.assertEquals("createCustomer did not return a customer with the correct name",
                newCustomer.getCustomerName(), createdCustomer.getCustomerName());
        Assert.assertEquals("createCustomer did not return a customer with the correct address 1",
                newCustomer.getStreetAddress(), createdCustomer.getStreetAddress());
        Assert.assertEquals("createCustomer did not return a customer with the correct phone number",
                newCustomer.getPhoneNumber(), createdCustomer.getPhoneNumber());
        Assert.assertEquals("createCustomer did not return a customer with the correct email",
                newCustomer.getEmail(), createdCustomer.getEmail());
        Assert.assertEquals("createCustomer did not return a customer with the correct date of birth",
                newCustomer.getDateOfBirth(), createdCustomer.getDateOfBirth());

        int newId = createdCustomer.getCustomerId();
        Customer retrievedCustomer = dao.getCustomerById(newId);
        Assert.assertNotNull("createdCustomer does not appear to have correctly persisted the newly created customer. It could not be found by id.", retrievedCustomer);
        assertCustomersMatch("createCustomer does not appear to have fully persisted the newly created customer. The retrieved customer is incorrect/incomplete", createdCustomer, retrievedCustomer);

    }

    @Test
    public void deleteCustomerById_deletes_customer_by_id() {
        int rowsAffected = dao.deleteCustomerById(1);

        Assert.assertEquals("deleteCustomer did not remove the customer from the database.", 1, rowsAffected);
        Customer retrievedCustomer = dao.getCustomerById(1);
        Assert.assertNull(retrievedCustomer);
    }
    public void assertCustomersMatch(String message, Customer expected, Customer actual) {
        Assert.assertEquals(message, expected.getCustomerId(), actual.getCustomerId());
        Assert.assertEquals(message, expected.getCustomerName(), actual.getCustomerName());
        Assert.assertEquals(message, expected.getStreetAddress(), actual.getStreetAddress());
        Assert.assertEquals(message, expected.getPhoneNumber(), actual.getPhoneNumber());
        Assert.assertEquals(message, expected.getEmail(), actual.getEmail());
        Assert.assertEquals(message, expected.getDateOfBirth(), actual.getDateOfBirth());
    }
}