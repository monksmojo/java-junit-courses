package com.in28Minutes.junitExmple1.serviceImpl;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSumServiceImpl {

    public int calculateListSum(int[] numbers) {
        int result=0;
        for(int num:numbers){
            result+=num;
        }
        return result;
    }


    public int listSumSize(int[] numbers) {
        return numbers.length;
    }

    public int listSumGetFirst(int[] numbers) {
        return numbers[0];
    }
}
