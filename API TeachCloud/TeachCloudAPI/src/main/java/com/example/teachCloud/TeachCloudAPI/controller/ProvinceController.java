package com.example.teachCloud.TeachCloudAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teachCloud.TeachCloudAPI.model.Province;
import com.example.teachCloud.TeachCloudAPI.model.Town;
import com.example.teachCloud.TeachCloudAPI.modelDto.ProvinceDto;
import com.example.teachCloud.TeachCloudAPI.service.ProvinceServiceImpl;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {

    @Autowired
    ProvinceServiceImpl provinceServiceImpl;

    @PostMapping("/add")
    public ProvinceDto addProvince(@RequestBody Province province){
        province.setTownsList(new ArrayList<Town>());
        Province p = provinceServiceImpl.saveProvince(province);
        ProvinceDto pDto = new ProvinceDto();
        pDto.setId(p.getId());
        pDto.setName(p.getName());
        return pDto;
    }

    @GetMapping("/allProvinces")
    public List<ProvinceDto> getAllProvinces(){
        List<Province> provinceList = provinceServiceImpl.getAllProvinces();
        List<ProvinceDto> responseList = new ArrayList<>();

        for(Province p: provinceList){
            ProvinceDto pDto = new ProvinceDto();
            pDto.setId(p.getId());
            pDto.setName(p.getName());
            responseList.add(pDto);

        }
        return responseList;
    }

    @GetMapping("/byId")
    public ProvinceDto getProvinceById(@RequestParam int id){
        Province p = provinceServiceImpl.getProvinceById(id);
        return new ProvinceDto(p.getId(), p.getName());
    }
    
}
