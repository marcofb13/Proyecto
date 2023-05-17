package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teachCloud.TeachCloudAPI.model.Subject;
import com.example.teachCloud.TeachCloudAPI.repository.SubjectRepo;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepo subjectRepo;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public Subject getSubjectById(int id) {
        return subjectRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSubjectById(int id) {
        subjectRepo.deleteById(id);
    }
    
}
