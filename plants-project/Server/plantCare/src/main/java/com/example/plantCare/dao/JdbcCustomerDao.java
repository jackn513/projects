package com.example.plantCare.dao;

import com.example.plantCare.exception.DaoException;
import com.example.plantCare.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class JdbcCustomerDao implements CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomerDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                customers.add(mapRowToCustomers(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return null;
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        return null;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        if (email == null) {
            System.out.println(email = "");
        }
       Customer customer = null;
        String sql = "SELECT * FROM customer WHERE email ILIKE ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, email);
            if (results.next()) {
                customer = mapRowToCustomers(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return customer;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        // TODO finish this method
        return null;
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer) {
        return null;
    }

    @Override
    public Customer deleteCustomer(int customerId) {
        return null;
    }

    public Customer mapRowToCustomers(SqlRowSet rowSet){
        Customer customer = new Customer();
        customer.setCustomerId(rowSet.getInt("customer_id"));
        customer.setCustomerName(rowSet.getString("customer_name"));
        customer.setProfileBio(rowSet.getString("profile_bio"));
        customer.setProfilePic(rowSet.getString("profile_image"));
        customer.setEmail(rowSet.getString("email"));
        customer.setPassword(rowSet.getString("password"));
        if (rowSet.getDate("created_at") != null){
            customer.setCreated(rowSet.getDate("created_at").toLocalDate());
        }
        if (rowSet.getDate("updated_at") != null){
            customer.setUpdated(rowSet.getDate("updated_at").toLocalDate());
        }
        customer.setActivated(true);
        customer.setAuthorities(Objects.requireNonNull(rowSet.getString("role")));
        return customer;
    }
}
