package com.example.teachCloud.TeachCloudAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teachCloud.TeachCloudAPI.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

    User findByEmail(String email);
    
}
