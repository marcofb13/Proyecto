package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import com.example.teachCloud.TeachCloudAPI.model.User;

public interface UserService {

    public List<User> getAllUsers();

    public User saveUser(User user);

    public User getUserById(int id);

    public void deleteUserById(int id);
    
    public User findUserByEmail(String email);
}
