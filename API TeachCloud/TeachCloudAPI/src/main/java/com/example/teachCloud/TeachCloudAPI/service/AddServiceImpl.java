package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teachCloud.TeachCloudAPI.model.Add;
import com.example.teachCloud.TeachCloudAPI.repository.AddRepo;

@Service
public class AddServiceImpl implements AddService{

    @Autowired
    AddRepo addRepo;

    @Override
    public List<Add> getAllAdds() {
        return addRepo.findAll();
    }

    @Override
    public Add saveAdd(Add add) {
        return addRepo.save(add);
    }

    @Override
    public Add getAddById(int id) {
        return addRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteAddById(int id) {
        addRepo.deleteById(id);
    }

    @Override
    public List<Add> findByUserId(int id) {
        return addRepo.findByUserId(id);
    }
    
}
