package com.in28Minutes.junitExmple1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface GetArrayRepository {

    public int[] feedArray();

}
