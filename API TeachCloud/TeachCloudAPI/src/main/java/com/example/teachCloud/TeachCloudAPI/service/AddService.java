package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import com.example.teachCloud.TeachCloudAPI.model.Add;

public interface AddService {

    public List<Add> getAllAdds();

    public Add saveAdd(Add add);

    public Add getAddById(int id);

    public void deleteAddById(int id);

    public List<Add> findByUserId(int id);
    
    
}
