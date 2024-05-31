package com.example.plantCare.security;

import com.example.plantCare.dao.CustomerDao;
import com.example.plantCare.model.Customer;
import com.example.plantCare.model.Authority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserModelDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserModelDetailsService.class);


    private final CustomerDao customerDao;

    public UserModelDetailsService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating user '{}'", login);
        return createSpringSecurityUser(login, customerDao.getCustomerByEmail(login));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String login, Customer customer) {
        if (!customer.isActivated()) {
            throw new UserNotActivatedException("com/example.plantCare/dao/user " + login + " was not activated");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Set<Authority> userAuthorities = customer.getAuthorities();
        for (Authority authority : userAuthorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }

        return new org.springframework.security.core.userdetails.User(customer.getEmail(),
                customer.getPassword(),
                grantedAuthorities);
    }
}
