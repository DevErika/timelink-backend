package com.timelink.timelink.service;
import java.util.List;

import com.timelink.timelink.model.User;


public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User getUserByEmail(String email);
    boolean existsByEmail(String email); 



    
}
