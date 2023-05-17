package com.example.teachCloud.TeachCloudAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teachCloud.TeachCloudAPI.model.Add;
import com.example.teachCloud.TeachCloudAPI.model.Province;
import com.example.teachCloud.TeachCloudAPI.model.Subject;
import com.example.teachCloud.TeachCloudAPI.model.Town;
import com.example.teachCloud.TeachCloudAPI.model.User;
import com.example.teachCloud.TeachCloudAPI.modelDto.AddToShow;
import com.example.teachCloud.TeachCloudAPI.repository.AddRepo;
import com.example.teachCloud.TeachCloudAPI.repository.ProvinceRepo;
import com.example.teachCloud.TeachCloudAPI.repository.SubjectRepo;
import com.example.teachCloud.TeachCloudAPI.repository.TownRepo;
import com.example.teachCloud.TeachCloudAPI.repository.UserRepo;

@Service
public class AddToShowServiceImpl {

    @Autowired
    AddRepo addRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProvinceRepo provinceRepo;

    @Autowired
    TownRepo townRepo;

    @Autowired
    SubjectRepo subjectRepo;



    public List<AddToShow> listOfAddsToShowByUserId(int id){
        List<Add> addsList = addRepo.findByUserId(id);
        List<AddToShow> atsList = new ArrayList<>();

        for(Add a: addsList){

            AddToShow ats = new AddToShow();
            User u = userRepo.findById(a.getUser().getId()).orElse(null);
            ats.setName(u.getName());
            ats.setPhone(u.getPhoneNumber());
            ats.setDescription(a.getDescription());

            Province p = provinceRepo.findById(a.getProvince().getId()).orElse(null);
            ats.setProvince(p.getName());

            Town t = townRepo.findById(a.getTown().getId()).orElse(null);
            ats.setTown(t.getName());

            Subject s = subjectRepo.findById(a.getSubject().getId()).orElse(null);
            ats.setSubject(s.getName());

            atsList.add(ats);

        }

        return atsList;
    }
    
}
