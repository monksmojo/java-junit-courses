package com.in28minutes.junitmockito.serviceTest;

import com.in28minutes.junitmockito.data.SomeDataImpl;
import com.in28minutes.junitmockito.service.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StubDataImpl implements SomeDataImpl {


    @Override
    public int[] retrieveData() {
        return new int[]{1,2,3,4};
    }
}

class StubNullDataImpl implements SomeDataImpl {


    @Override
    public int[] retrieveData() {
        return new int[]{};
    }
}

@SpringBootTest
public class SomeServiceTestWithStub {

    @Autowired
    SomeServiceImpl someService;

    @Test
    public void testingWithStubForNormalInput(){
        someService.setSomeData(new StubDataImpl());
        int actualResult=someService.calculateSumWithDataService();
        int expectedResult=10;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testingWithStubNullInput(){
        someService.setSomeData(new StubNullDataImpl());
        int actualResult=someService.calculateSumWithDataService();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }
}
