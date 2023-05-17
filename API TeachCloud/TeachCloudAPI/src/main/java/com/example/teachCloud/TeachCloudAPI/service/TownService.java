package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import com.example.teachCloud.TeachCloudAPI.model.Town;

public interface TownService {

    public List<Town> getAllTowns();

    public Town saveTown(Town town);

    public Town getTownById(int id);

    public void deleteTownById(int id);
    
}
