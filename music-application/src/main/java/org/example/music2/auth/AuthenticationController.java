package org.example.music2.auth;

import lombok.RequiredArgsConstructor;
import org.example.music2.dao.Users.UserDao;
import org.example.music2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AuthenticationService service;
    private final UserDao userDao; // Inject UserDao

    @PostMapping("/register") // Endpoint for user registration
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        // You can use userDao to save user data
        User user = userDao.getUserByFirstName(request.getFirstName());

        // Check if the user already exists
        User existingUser = userDao.getUserByFirstName(request.getFirstName());
        if (existingUser != null) {
            // User already exists, return an error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthenticationResponse("User with this email already exists"));
        }
        userDao.save(user);
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate") // Endpoint for user authentication
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}