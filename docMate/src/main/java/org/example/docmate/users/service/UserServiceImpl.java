package org.example.docmate.users.service;

import org.example.docmate.users.model.User;
import org.example.docmate.users.UserDto;
import org.example.docmate.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInt {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDto userDto) {
        if (userDto.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        User user = new User(
                userDto.getUsername(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()));
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

}
