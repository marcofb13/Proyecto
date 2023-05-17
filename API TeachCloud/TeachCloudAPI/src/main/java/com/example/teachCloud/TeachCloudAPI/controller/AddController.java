package com.example.teachCloud.TeachCloudAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teachCloud.TeachCloudAPI.model.Add;
import com.example.teachCloud.TeachCloudAPI.model.Province;
import com.example.teachCloud.TeachCloudAPI.model.Subject;
import com.example.teachCloud.TeachCloudAPI.model.Town;
import com.example.teachCloud.TeachCloudAPI.model.User;
import com.example.teachCloud.TeachCloudAPI.modelDto.AddDto;
import com.example.teachCloud.TeachCloudAPI.modelDto.AddToShow;
import com.example.teachCloud.TeachCloudAPI.service.AddServiceImpl;
import com.example.teachCloud.TeachCloudAPI.service.AddToShowServiceImpl;

@RestController
@RequestMapping("/adds")
public class AddController {

    @Autowired
    AddServiceImpl addServiceImpl;

    @Autowired
    AddToShowServiceImpl atsServiceImpl;

    @PostMapping("/add")
    public AddDto addAdd(@RequestBody AddDto add){

        Add addToSave = new Add();
        addToSave.setDescription(add.getDescription());

        Province p = new Province();
        p.setId(add.getProvince_id());
        addToSave.setProvince(p);

        Town t = new Town();
        t.setId(add.getTown_id());
        addToSave.setTown(t);

        Subject s = new Subject();
        s.setId(add.getSubject_id());
        addToSave.setSubject(s);

        User u = new User();
        u.setId(add.getUser_id());      
        addToSave.setUser(u);

        addServiceImpl.saveAdd(addToSave);

        add.setId(addToSave.getId());
        return add;

    }

    @GetMapping("/allAdds")
    public List<AddDto> getAllAdds(){
        List<AddDto> responseList= new ArrayList<>();
 
        List<Add> addList = addServiceImpl.getAllAdds();

        for(Add a: addList){
            AddDto aDto = new AddDto(a.getId(), a.getDescription(), a.getProvince().getId(),
             a.getTown().getId(), a.getSubject().getId(), a.getUser().getId());
             responseList.add(aDto);
        }
        
        return responseList;

    }

    @GetMapping("/filterAdds")
    public List<AddDto> getFilteredAdds(@RequestParam int province_id, @RequestParam int town_id, @RequestParam int subject_id){

        List<AddDto> responseList = new ArrayList<>();

        List<AddDto> allAdds = getAllAdds();

        for(AddDto add: allAdds){
            if(add.getProvince_id()==province_id && add.getTown_id()==town_id && add.getSubject_id()==subject_id){
                responseList.add(add);
            }
        }

        return responseList;
    }

    @GetMapping("/addsByUserId")
    public List<AddDto> getAddsByUserId(@RequestParam int user_id){
        List<AddDto> responseList = new ArrayList<>();
        List<Add> addsList = addServiceImpl.findByUserId(user_id);

        for(Add a:addsList){
            AddDto addDto = new AddDto(a.getId(), a.getDescription(), a.getProvince().getId(),
            a.getTown().getId(), a.getSubject().getId(), a.getUser().getId());
            responseList.add(addDto);
        }

        return responseList;
    }

    @GetMapping("/addsToShowByUserId")
    public List<AddToShow> getAddsToShowByUserId(@RequestParam int user_id){
        return atsServiceImpl.listOfAddsToShowByUserId(user_id);
    }

    @DeleteMapping("/deleteById")
    public String deleteAddById(@RequestParam int id){
        addServiceImpl.deleteAddById(id);
        return "Borrado";
    }
    
}
