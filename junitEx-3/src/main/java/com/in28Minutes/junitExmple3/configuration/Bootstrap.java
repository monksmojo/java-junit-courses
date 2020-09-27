package com.in28Minutes.junitExmple3.configuration;


import com.in28Minutes.junitExmple3.model.Project;
import com.in28Minutes.junitExmple3.repository.ProjectRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
@Log4j2
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Project> projectArrayList=  Arrays.asList(
          new Project("my cloud bill desk","rahul deo",7),
                new Project("ott","sensei",60),
                new Project("broadBand","captain",90),
                new Project("beach","chief",0) );

        projectRepository.saveAll(projectArrayList);
        log.info("database populated");
    }
}
