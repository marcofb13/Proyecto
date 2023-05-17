package com.example.teachCloud.TeachCloudAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teachCloud.TeachCloudAPI.model.Subject;
import com.example.teachCloud.TeachCloudAPI.modelDto.SubjectDto;
import com.example.teachCloud.TeachCloudAPI.service.SubjectServiceImpl;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectServiceImpl subjectServiceImpl;

    @GetMapping("/allSubjects")
    public List<SubjectDto> getAllSubjects(){
        List<SubjectDto> responseList = new ArrayList<>();

        List<Subject> subjectList = subjectServiceImpl.getAllSubjects();

        for(Subject s: subjectList){
            SubjectDto sDto = new SubjectDto(s.getId(),s.getName());
            responseList.add(sDto);
        }

        return responseList;
        
    }
    
}
