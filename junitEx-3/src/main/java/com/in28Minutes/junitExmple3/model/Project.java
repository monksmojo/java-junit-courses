package com.in28Minutes.junitExmple3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long ProjectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_owner")
    private String projectOwner;

    @Column(name = "team_size")
    private Integer teamSize;

    public Project(String projectName, String projectOwner, Integer teamSize) {
        this.projectName = projectName;
        this.projectOwner = projectOwner;
        this.teamSize = teamSize;
    }
}
