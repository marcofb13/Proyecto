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
import com.example.teachCloud.TeachCloudAPI.modelDto.TownDto;
import com.example.teachCloud.TeachCloudAPI.service.ProvinceServiceImpl;
import com.example.teachCloud.TeachCloudAPI.service.TownServiceImpl;

@RestController
@RequestMapping("/towns")
public class TownController {
    
    @Autowired
    TownServiceImpl townServiceImpl;

    @Autowired
    ProvinceServiceImpl provinceServiceImpl;

    @PostMapping("/add")
    public TownDto addTown(@RequestBody Town town){
        Town t = townServiceImpl.saveTown(town);
        TownDto tDto = new TownDto();
        tDto.setId(t.getId());
        tDto.setName(t.getName());
        tDto.setProvince_id(t.getProvince().getId());

        return tDto;
    }

    @GetMapping("/allTowns")
    public List<TownDto> getAllTowns(){
        List<Town> townsList= townServiceImpl.getAllTowns();
        List<TownDto> responseList= new ArrayList<>();

        for(Town t: townsList){
            TownDto tDto = new TownDto();
            tDto.setId(t.getId());
            tDto.setName(t.getName());
            tDto.setProvince_id(t.getProvince().getId());
            responseList.add(tDto);
        }


        return responseList;
    }

    @GetMapping("/byProvinceId")
    public List<TownDto> getTownsByProvinceId(@RequestParam int id){

        Province proviceById = provinceServiceImpl.getProvinceById(id);
        List<Town> townsById = proviceById.getTownsList();

        List<TownDto> responseList = new ArrayList<>();
        for(Town t: townsById){
            TownDto tDto = new TownDto(t.getId(), t.getName(), t.getProvince().getId());
            responseList.add(tDto);

        }
        
        return responseList;
    }
}
