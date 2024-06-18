package com.example.plantCare.controller;

import com.example.plantCare.dao.CustomerDao;
import com.example.plantCare.exception.DaoException;
import com.example.plantCare.model.Customer;
import com.example.plantCare.model.LoginDto;
import com.example.plantCare.model.LoginResponseDto;
import com.example.plantCare.model.RegisterUserDto;
import com.example.plantCare.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private CustomerDao customerDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, CustomerDao customerDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.customerDao = customerDao;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginDto loginDto) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.createToken(authentication, false);

            Customer customer = customerDao.getCustomerByEmail(loginDto.getEmail());
            return new LoginResponseDto(jwt, customer);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO error - " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public Customer register(@Valid @RequestBody RegisterUserDto newCustomerDto) {
        // Validation and error handling omitted for brevity
        try {
            Customer newCustomer = new Customer();
            newCustomer.setCustomerName(newCustomerDto.getCustomerName());
            newCustomer.setProfileBio(newCustomerDto.getProfileBio());
            newCustomer.setProfileImage(newCustomerDto.getProfileImage());
            newCustomer.setEmail(newCustomerDto.getEmail());
            newCustomer.setPassword(newCustomerDto.getPassword());
            newCustomer.setRole(newCustomerDto.getRole());

            return customerDao.createCustomer(newCustomer);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO error - " + e.getMessage());
        }
    }
}
