//package org.example.music2.controller;
//
//import org.example.music2.dao.Users.UserDao;
//import org.example.music2.model.User;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    private final UserDao userDao;
//    public UserController(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @RequestMapping(path="/users", method = RequestMethod.GET)
//    public List<User> getUsers(){
//        return userDao.getUsers();
//    }
//
//}
