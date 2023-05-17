package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import com.example.teachCloud.TeachCloudAPI.model.Province;

public interface ProvinceService {
    
    public List<Province> getAllProvinces();

    public Province saveProvince(Province province);

    public Province getProvinceById(int id);

    public void deleteProvinceById(int id);
}
