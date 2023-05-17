package com.example.teachCloud.TeachCloudAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teachCloud.TeachCloudAPI.model.Town;

@Repository
public interface TownRepo extends JpaRepository<Town,Integer>{
    
}
