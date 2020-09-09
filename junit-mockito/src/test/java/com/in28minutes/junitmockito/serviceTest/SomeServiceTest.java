package com.in28minutes.junitmockito.serviceTest;


import com.in28minutes.junitmockito.service.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SomeServiceTest {

    @Autowired
    SomeServiceImpl someService;

    @Test
    public void testingCalculateSumForNormalInput() {
        int actualResult = someService.calculateSumWithHardData(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void testingCalculateForNullInput() {
    	int actual=someService.calculateSumWithHardData(new int[] {});
    	int expectedResult=0;
    	assertEquals(expectedResult, actual);
    }


    // testing a unit test  with stub
}
