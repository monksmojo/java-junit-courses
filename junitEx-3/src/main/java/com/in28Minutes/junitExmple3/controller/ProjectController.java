package com.in28Minutes.junitExmple3.controller;

import com.in28Minutes.junitExmple3.model.Project;
import com.in28Minutes.junitExmple3.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "/test")
    public ResponseEntity<String> testProject(){
        return new ResponseEntity<>("testing controller",HttpStatus.OK);
    }

    @GetMapping(path = "/get/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable Long projectId){
        Project project=projectService.getProject(projectId);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Boolean> saveProject(@RequestBody Project project){
        Boolean saved=projectService.saveProject(project);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
}
