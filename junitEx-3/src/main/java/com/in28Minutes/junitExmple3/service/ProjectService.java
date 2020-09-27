package com.in28Minutes.junitExmple3.service;

import com.in28Minutes.junitExmple3.model.Project;
import com.in28Minutes.junitExmple3.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project getProject(Long projectId){
        return projectRepository.findById(projectId).orElse(null);
    }

    public Boolean saveProject(Project project){
        projectRepository.save(project);
        return true;
    }



}
