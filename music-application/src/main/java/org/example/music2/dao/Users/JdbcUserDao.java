package org.example.music2.dao.Users;

import org.example.music2.exception.DaoException;
import org.example.music2.model.Album;
import org.example.music2.model.Role;
import org.example.music2.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Service
public class JdbcUserDao implements UserDao{
    public JdbcUserDao (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM _user";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()){
                users.add(mapRowToUser(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return users;


    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        String sql = "SELECT * FROM _user WHERE customer_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()){
                user = mapRowToUser(results);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return user;
    }

    @Override
    public User create(User user) {
        int userId;
        String sql = "INSERT INTO _user (first_name, last_name, email, password, role) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING customer_id;";
       try {
           Role role = (user.getRole() != null) ? user.getRole() : Role.USER;
           userId =  jdbcTemplate.queryForObject(sql, int.class,
                   user.getFirstName(),
                   user.getLastName(),
                   user.getEmail(),
                   user.getPassword(),
                   role.toString().toUpperCase());
       } catch (CannotGetJdbcConnectionException e) {
           throw new DaoException("Unable to connect to server or database", e);
       } catch (DataIntegrityViolationException e) {
           throw new DaoException("Data integrity violation", e);
       }
       return getUserById(userId);
    }

    @Override
    public User getUserByFirstName(String firstName) {
        User user = null;
        String sql = "SELECT * FROM _user WHERE first_name = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstName);
            if (results.next()) {
                user = mapRowToUser(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return user;
    }

    @Override
    public User save(User user) {
        return null;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setCustomerId(rowSet.getInt("customer_id"));
        user.setFirstName(rowSet.getString("first_name"));
        user.setLastName(rowSet.getString("last_name"));
        user.setEmail(rowSet.getString("email"));
        user.setPassword(rowSet.getString("password"));
        user.setRole(Role.valueOf(rowSet.getString("role").toUpperCase()));
        return user;
    }
}
