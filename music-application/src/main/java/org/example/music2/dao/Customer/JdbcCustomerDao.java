package org.example.music2.dao.Customer;


import org.example.music2.exception.DaoException;
import org.example.music2.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcCustomerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        String sql =
                "SELECT * FROM customer WHERE customer_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
            if (results.next()) {
                customer = mapRowToCustomer(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        List <Customer> customers = new ArrayList<>();
        String sql =
                "SELECT * FROM customer;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                customers.add(mapRowToCustomer(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return customers;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        String sql = "INSERT INTO customer (customer_name, street_address, phone_number, email, date_of_birth) " +
                "VALUES (?,?,?,?,?) RETURNING customer_id;";
        int customerId;
        try {
            customerId = jdbcTemplate.queryForObject(sql,
                    Integer.class,
                    newCustomer.getCustomerName(),
                    newCustomer.getStreetAddress(),
                    newCustomer.getPhoneNumber(),
                    newCustomer.getEmail(),
                    newCustomer.getDateOfBirth());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return getCustomerById(customerId);
    }

    @Override
    public int deleteCustomerById(int customerId) {
        int numOfRows;
        String sqlSale = "DELETE FROM sale WHERE customer_id = ?;";
        String sqlCustomer = "DELETE FROM customer WHERE customer_id =?;";
        try {
            jdbcTemplate.update(sqlSale, customerId);
            numOfRows = jdbcTemplate.update(sqlCustomer, customerId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numOfRows;
    }

    private Customer mapRowToCustomer(SqlRowSet rowSet) {
        Customer customer = new Customer();
        customer.setCustomerId(rowSet.getInt("customer_id"));
        customer.setCustomerName(rowSet.getString("customer_name"));
        if (rowSet.getString("street_address") != null) {
            customer.setStreetAddress(rowSet.getString("street_address"));
        }
        if (rowSet.getString("phone_number") != null) {
            customer.setPhoneNumber(rowSet.getString("phone_number"));
        }
        customer.setEmail(rowSet.getString("email"));
        customer.setDateOfBirth(rowSet.getDate("date_of_birth").toLocalDate());
        customer.setStreetAddress(rowSet.getString("street_address"));
        return customer;
    }

}
