package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teachCloud.TeachCloudAPI.model.Town;
import com.example.teachCloud.TeachCloudAPI.repository.TownRepo;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    TownRepo townRepo;

    @Override
    public List<Town> getAllTowns() {
        return townRepo.findAll();
    }

    @Override
    public Town saveTown(Town town) {
        return townRepo.save(town);
    }

    @Override
    public Town getTownById(int id) {
        return townRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteTownById(int id) {
        townRepo.deleteById(id);
    }
    
}
