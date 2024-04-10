package org.example.music2.dao.Users;

import org.example.music2.model.User;
import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int userId);

    User getUserByUsername(String username);

    User createUser(User newUser);
}
