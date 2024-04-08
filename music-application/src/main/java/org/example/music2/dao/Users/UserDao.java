package org.example.music2.dao.Users;

import org.example.music2.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUsers();
    User getUserById(int userId);

    User create(User user);

    User getUserByFirstName(String firstName);

    User save(User user);
}
