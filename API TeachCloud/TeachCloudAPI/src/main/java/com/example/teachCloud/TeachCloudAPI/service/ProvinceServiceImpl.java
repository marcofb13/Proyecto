package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teachCloud.TeachCloudAPI.model.Province;
import com.example.teachCloud.TeachCloudAPI.repository.ProvinceRepo;

@Service
public class ProvinceServiceImpl implements ProvinceService{

    @Autowired
    ProvinceRepo provinceRepo;

    @Override
    public List<Province> getAllProvinces() {
        return provinceRepo.findAll();
    }

    @Override
    public Province saveProvince(Province province) {
        return provinceRepo.save(province);
    }

    @Override
    public Province getProvinceById(int id) {
        return provinceRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProvinceById(int id) {
        provinceRepo.deleteById(id);
    }
    
}
