package com.in28Minutes.junitExmple3.repository;

import com.in28Minutes.junitExmple3.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
