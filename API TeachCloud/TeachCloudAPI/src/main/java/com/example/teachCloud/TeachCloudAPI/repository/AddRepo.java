package com.example.teachCloud.TeachCloudAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teachCloud.TeachCloudAPI.model.Add;

@Repository
public interface AddRepo extends JpaRepository<Add,Integer>{

    List<Add> findByUserId(int userId);
    
}
