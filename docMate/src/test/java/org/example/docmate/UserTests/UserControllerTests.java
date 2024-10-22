package org.example.docmate.UserTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.example.docmate.users.JWT.JWTTokenProvider;
import org.example.docmate.users.JWT.TokenService;
import org.example.docmate.users.UserLoginDto;
import org.example.docmate.users.controller.UserController;
import org.example.docmate.users.model.User;
import org.example.docmate.users.service.CustomUserDetailsService;
import org.example.docmate.users.service.TokenBlacklistService;
import org.example.docmate.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private  CustomUserDetailsService customUserDetailsService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private TokenBlacklistService tokenBlacklistService;

    @MockBean
    private UserService userService;

    @MockBean
    private JWTTokenProvider jwtTokenProvider;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        // Initialize all required services for the UserController
        mockMvc = MockMvcBuilders.standaloneSetup(
                new UserController(customUserDetailsService, tokenService, tokenBlacklistService, userService, jwtTokenProvider)
        ).build();
    }

    @Test
    void whenValidInput_thenRegisterUser() throws Exception {
        String user = objectMapper.writeValueAsString(new User("test", "test@example.com", passwordEncoder.encode("test")));

        mockMvc.perform(post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(user))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidInput_thenLogin() throws Exception {
        UserLoginDto loginDto = new UserLoginDto("test", "test");

        User user = new User("test", "test@example.com", passwordEncoder.encode("test"));

        given(userService.findByUsername(loginDto.getUsername())).willReturn(user);
        given(userService.testPassword(loginDto.getPassword(), user.getPassword())).willReturn(true);
        given(jwtTokenProvider.createToken(loginDto.getUsername())).willReturn("mockedToken");

        String loginInput = objectMapper.writeValueAsString(loginDto);

        mockMvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginInput))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Login successful. Token: mockedToken")));
    }

    @Test
    void whenValidInput_thenLogout() throws Exception {
        UserLoginDto loginDto = new UserLoginDto("test", "test");

        User user = new User("test", "test@example.com", passwordEncoder.encode("test"));

        given(userService.findByUsername(loginDto.getUsername())).willReturn(user);
        String mockedToken = "mockedToken";
        given(jwtTokenProvider.createToken(loginDto.getUsername())).willReturn(mockedToken);
        given(tokenService.extractTokenFromRequest(any(HttpServletRequest.class))).willReturn(mockedToken);
        given(jwtTokenProvider.validateToken(mockedToken)).willReturn(true);

        doNothing().when(tokenBlacklistService).addToBlacklist(mockedToken);

        Authentication auth = Mockito.mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(auth);
        given(auth.getName()).willReturn(user.getUsername());

        mockMvc.perform(post("/users/logout")
                        .header("Authorization", "Bearer " + mockedToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Logout successful for user: test")));
    }

    @Test
    void testGetUsers_returnsUsersList() throws Exception {
        List<User> mockUsers = Arrays.asList(
                new User("test1", "test1@example.com", passwordEncoder.encode("test1")),
                new User("test2", "test2@example.com", passwordEncoder.encode("test2"))
        );

        given(userService.findAll()).willReturn(mockUsers);

        mockMvc.perform(get("/users")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(mockUsers))); // Ensure this is the right call
    }
}
