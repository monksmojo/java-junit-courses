package com.in28minutes.junitmockito.service;

import com.in28minutes.junitmockito.data.SomeDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl {

    private SomeDataImpl someData;

    public void setSomeData(SomeDataImpl someData) {
        this.someData = someData;
    }

    public int calculateSumWithHardData(int[] integerArray){
        int result=0;
        for (int num:integerArray) {
            result+=num;
        }
        return result;
    }

    public int calculateSumWithDataService(){
        int result=0;
        int[] integerArray=someData.retrieveData();
        for(int num:integerArray){
            result+=num;
        }
        return result;
    }
}
