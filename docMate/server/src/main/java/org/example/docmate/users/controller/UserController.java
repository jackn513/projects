package org.example.docmate.users.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.docmate.users.model.User;
import org.example.docmate.users.JWT.JWTTokenProvider;
import org.example.docmate.users.JWT.TokenService;
import org.example.docmate.users.service.TokenBlacklistService;
import org.example.docmate.users.UserDto;
import org.example.docmate.users.UserLoginDto;
import org.example.docmate.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private final UserDetailsService userDetailsService;

    @Autowired
    private final TokenService tokenService;

    @Autowired
    private final TokenBlacklistService tokenBlacklistService;

    @Autowired
    private final UserService userService;

    @Autowired
    private final JWTTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(
            UserDetailsService userDetailsService,
            TokenService tokenService,
            TokenBlacklistService tokenBlacklistService,
            UserService userService,
            JWTTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.tokenService = tokenService;
        this.tokenBlacklistService = tokenBlacklistService;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }



    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);
        return "home";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        try {
            User newUser = userService.registerUser(userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
            return ResponseEntity.ok(newUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Unable to register user: " + e.getMessage());
        }

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto loginDto) {

        User user = userService.findByUsername(loginDto.getUsername());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found.");
        }


        boolean isPasswordValid = userService.testPassword(loginDto.getPassword(), user.getPassword());
        if (!isPasswordValid) {
            System.out.println("Invalid password for user: " + loginDto.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Invalid password.");
        }


        String token = jwtTokenProvider.createToken(loginDto.getUsername());


        return ResponseEntity.ok("Login successful. Token: " + token);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {

        String token = tokenService.extractTokenFromRequest(request);

        if (token == null || !jwtTokenProvider.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
        }


        tokenBlacklistService.addToBlacklist(token);


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = null;

        if (auth != null) {
            username = auth.getName();
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        return ResponseEntity.ok("Logout successful for user: " + username);
    }


    // todo change credentials for only admin can do this //
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/userid/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {

        if (id < 1) {
            return ResponseEntity.badRequest().body("id must be greater than or equal to one");
        }
        User user = userService.findByUserId(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok(user);
    }


    @GetMapping
    @PreAuthorize("hasAnyRole()")
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }



    // todo update so just the specific user and / or admin can do this //
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
        if (id < 1) {
            return ResponseEntity.badRequest().body("id must be greater than or equal to one");
        }

        try {

            User updatedUser = userService.updateUser(user, id);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    // todo change credentials so only admin can do this //
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        if (id < 1) {
            return ResponseEntity.badRequest().body("Id must be greater than or equal to one");
        }
        User user = userService.findByUserId(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        int deletedRows = userService.deleteByUserId(id);
        if (deletedRows == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user");
        }
        return ResponseEntity.ok("User deleted successfully");
    }


}
