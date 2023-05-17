package com.example.teachCloud.TeachCloudAPI.service;

import java.util.List;

import com.example.teachCloud.TeachCloudAPI.model.Subject;

public interface SubjectService {

    public List<Subject> getAllSubjects();

    public Subject saveSubject(Subject subject);

    public Subject getSubjectById(int id);

    public void deleteSubjectById(int id);
    
}
