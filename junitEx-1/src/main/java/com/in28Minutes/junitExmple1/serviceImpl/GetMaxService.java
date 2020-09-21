package com.in28Minutes.junitExmple1.serviceImpl;

import com.in28Minutes.junitExmple1.repository.GetArrayRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@NoArgsConstructor
public class GetMaxService {

    @Autowired
    private GetArrayRepository getArrayService;

    public int maxElementIs(){
        int[] numbers=getArrayService.feedArray();
        return Arrays.stream(numbers).max().getAsInt();
    }

}
