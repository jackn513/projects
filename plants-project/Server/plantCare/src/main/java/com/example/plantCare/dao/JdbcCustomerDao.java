package com.example.plantCare.dao;

import com.example.plantCare.exception.DaoException;
import com.example.plantCare.model.Customer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        String sql = "SELECT customer_id, customer_name, profile_bio, profile_image, email, password, created_at, updated_at, role FROM customer ORDER BY customer_name";
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
            email = "";  // Avoid printing email to the console
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
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return customer;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {

        String sql = "INSERT INTO customer (customer_name, email, password, role)" +
                "VALUES (?, ?, ?, ?) RETURNING customer_id";

        // Validate required fields
        if (newCustomer.getCustomerName() == null || newCustomer.getEmail() == null || newCustomer.getRole() == null) {
            throw new DaoException("Customer Name, Email, and Role cannot be null");
        }

        // Ensure password is not null
        if (newCustomer.getPassword() == null) {
            throw new DaoException("User cannot be created with null password");
        }

        try {
            String passwordHash = new BCryptPasswordEncoder().encode(newCustomer.getPassword());

            // Perform the insert and retrieve the generated customer_id
            int customerId = jdbcTemplate.queryForObject(sql, int.class,
                    newCustomer.getCustomerName(), newCustomer.getEmail(), passwordHash, newCustomer.getRole());

            // Retrieve the newly created customer using customer_id
            Customer createdCustomer = getCustomerById(customerId);

            return createdCustomer;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation: " + e.getMessage(), e);
        }
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer) {
        String sql = "UPDATE customer " +
                "SET customer_name = ?, email = ?, password = ? " +
                "WHERE customer_id = ?";
        try {
            // Execute the update query
            jdbcTemplate.update(sql,
                    updatedCustomer.getCustomerName(),
                    updatedCustomer.getEmail(),
                    updatedCustomer.getPassword(),
                    updatedCustomer.getCustomerId());

            // Return the updated customer
            return getCustomerById(updatedCustomer.getCustomerId());
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Error updating customer: " + e.getMessage(), e);
        }
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
        customer.setProfileImage(rowSet.getString("profile_image"));
        customer.setEmail(rowSet.getString("email"));
        customer.setPassword(rowSet.getString("password"));
            customer.setCreatedAt(rowSet.getDate("created_at").toLocalDate().atStartOfDay());

            customer.setUpdatedAt(rowSet.getDate("updated_at").toLocalDate().atStartOfDay());
        customer.setAuthorities(Objects.requireNonNull(rowSet.getString("role")));
        customer.setActivated(true);
        return customer;
    }
}
