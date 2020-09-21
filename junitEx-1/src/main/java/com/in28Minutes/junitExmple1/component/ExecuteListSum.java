package com.in28Minutes.junitExmple1.component;

import com.in28Minutes.junitExmple1.serviceImpl.ListSumServiceImpl;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Slf4j
public class ExecuteListSum {


    @Autowired
    private ListSumServiceImpl listSumService;

    public int getSum(int[] numbers){
        int result= listSumService.calculateListSum(numbers);
        log.info("result is "+result);
        return result;
    }

    public  int getHardcodedSum(int[] numbers){
        int result=0;
        for(int num:numbers){
            result+=num;
        }
        return result;
    }

    public int getLength(int[] numbers ){
        int resultLength=listSumService.listSumSize(numbers);
        log.info("the length is"+resultLength);
        return resultLength;
    }

    public int getHardcodedLength(int [] numbers){
        return numbers.length;
    }

    public int getFirstElement(int [] numbers){
        log.info("the length is"+listSumService.listSumGetFirst(numbers));
        return listSumService.listSumGetFirst(numbers);
    }

    public int getFirstHardcodedElement(int [] numbers){
        return numbers[0];
    }


}
