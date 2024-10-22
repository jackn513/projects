package org.example.docmate.userTests;

import jakarta.transaction.Transactional;
import org.example.docmate.users.model.User;
import org.example.docmate.users.UserRepository;
import org.example.docmate.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DocMateUserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private User testUser;

    @BeforeEach
    void setUp() {

        userRepository.deleteAll();


        testUser = new User();
        testUser.setUsername("test" + System.currentTimeMillis());
        testUser.setEmail("test@example.com");
        testUser.setPassword(passwordEncoder.encode("test"));
        testUser.setRole("USER");
        userRepository.save(testUser);
    }

    @Test
    void testRegisterUser() {
        User createdUser = userService.registerUser(
                testUser.getUsername(),
                testUser.getEmail(),
                "test"
        );

        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getUsername()).isEqualTo(testUser.getUsername());
        assertThat(createdUser.getEmail()).isEqualTo(testUser.getEmail());
        assertThat(createdUser.getPassword()).isNotNull();
        assertThat(passwordEncoder.matches("test", createdUser.getPassword())).isTrue();
        assertThat(createdUser.getRole()).isEqualTo("USER");
    }

    @Test
    void testSaveAndFindUser() {
        User retrievedUser = userRepository.findByUsername(testUser.getUsername());

        assertThat(retrievedUser).isNotNull();
        assertThat(retrievedUser.getEmail()).isEqualTo(testUser.getEmail());
        assertThat(passwordEncoder.matches("test", retrievedUser.getPassword())).isTrue();
        assertThat(retrievedUser.getRole()).isEqualTo("USER");
    }

    @Test
    void testIfUserExists() {
        User existingUser = userRepository.findByUsername(testUser.getUsername());

        assertThat(existingUser).isNotNull();
    }

    @Test
    void testUserDoesNotExist() {
        String nonExistentUsername = "nonexistentUser" + System.currentTimeMillis();

        User nonExistentUser = userRepository.findByUsername(nonExistentUsername);

        assertThat(nonExistentUser).isNull();
    }

    @Test
    void testFindUserById() {
        User retrievedUser = userService.findByUserId(testUser.getUserId());

        assertThat(retrievedUser).isNotNull();
        assertThat(retrievedUser.getEmail()).isEqualTo(testUser.getEmail());
        assertThat(passwordEncoder.matches("test", retrievedUser.getPassword())).isTrue();
        assertThat(retrievedUser.getRole()).isEqualTo("USER");
    }

    @Test
    void testFindUserByUsername() {
        User retrievedUser = userRepository.findByUsername(testUser.getUsername());

        assertThat(retrievedUser).isNotNull();
        assertThat(retrievedUser.getEmail()).isEqualTo(testUser.getEmail());
        assertThat(passwordEncoder.matches("test", retrievedUser.getPassword())).isTrue();
        assertThat(retrievedUser.getRole()).isEqualTo("USER");
    }



    @Test
    void testUpdateUser() {
        User userToUpdate = userRepository.findByUsername(testUser.getUsername());
        userToUpdate.setEmail("updated@example.com");
        userToUpdate.setPassword(passwordEncoder.encode("updated"));
        userRepository.save(userToUpdate);

        User updatedUser = userRepository.findByUsername(userToUpdate.getUsername());
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getEmail()).isEqualTo("updated@example.com");
        assertThat(passwordEncoder.matches("updated", updatedUser.getPassword())).isTrue();
    }

    @Test
    void deleteAndTest() {
        userRepository.delete(testUser);

        User deletedUser = userRepository.findByUsername(testUser.getUsername());
        assertThat(deletedUser).isNull();
    }
}