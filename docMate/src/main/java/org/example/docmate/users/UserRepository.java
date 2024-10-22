package org.example.docmate.users;

import org.example.docmate.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {



    @Query("SELECT u FROM _users u where u.username ILIKE %:userName%")
    User findByUsername(@Param("userName") String userName);

    @Query("SELECT u FROM _users u where u.email ilike %:email%")
    User findByEmail(@Param("email") String email);


}
