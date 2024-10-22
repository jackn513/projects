package org.example.docmate.users.service;

import org.example.docmate.users.model.User;
import org.example.docmate.users.UserDto;

public interface UserServiceInt {

    User findByUsername(String username);

   User save(UserDto userDto);
}
