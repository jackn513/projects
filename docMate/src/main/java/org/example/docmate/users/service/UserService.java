package org.example.docmate.users.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.example.docmate.users.JWT.JWTTokenProvider;
import org.example.docmate.users.JWT.TokenService;
import org.example.docmate.users.model.User;
import org.example.docmate.users.UserRepository;
import org.example.docmate.exceptions.UnauthorizedException; // Adjust the package name as needed

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final JWTTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService, JWTTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.jwtTokenProvider = jwtTokenProvider;
    }



    // creates a new user //
    public User registerUser(String username, String email, String rawPassword) {
        if (rawPassword == null || rawPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));  // Call hashPassword here
        user.setRole("USER");
        user.setCreatedAt(Timestamp.from(Instant.now()));
        user.setUpdatedAt(Timestamp.from(Instant.now()));

        userRepository.save(user);
        return user;
    }



    public boolean testPassword(String rawPassword, String encodedPassword) {
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("Raw password entered: " + rawPassword);
        System.out.println("Encoded password from DB: " + encodedPassword);
        System.out.println("Is password valid? " + matches);
        return matches;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUserId(Integer userId) {

        if (userId < 1 ) {
            System.out.println("id must be greater than or equal to one");
        }
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            System.out.println("User not found");
        }
        return userRepository.findById(userId).orElse(null);
    }

    // todo update so just the specific user and / or admin can do this //
    @Transactional
    public User updateUser(User user, int id) {
        // Fetch the user by ID
        User theUser = userRepository.findById(id).orElse(null);

        // If the user is not found, throw an exception
        if (theUser == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Update the user's data //

        // Using if so that I can omit data that user doesn't want to be changed //
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            theUser.setUsername(user.getUsername());
        }
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            theUser.setEmail(user.getEmail());
        }

        // Encode the password and set it
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            theUser.setPassword(encodedPassword);
        }
        // Set the updated timestamp
        theUser.setUpdatedAt(Timestamp.from(Instant.now()));

        // Save and return the updated user
        return userRepository.save(theUser);
    }

    // todo change credentials so only admin can do this //
    @Transactional
    public int deleteByUserId(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);  // Use the repository to handle deletion
            return 1;  // Return 1 to indicate successful deletion
        }
        return 0;  // Return 0 if the user wasn't found
    }


    public User findById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
