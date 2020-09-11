package com.in28minutes.junitmockito.serviceTest;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@SpringBootTest
public class MockListVerifyMethodCallTest {

    @Test
    public void verificationBasics(){
        List<String> mockStringList=mock(List.class);
        // SUT -- system under test..
        String value=mockStringList.get(0);
        String value1=mockStringList.get(1);
        String value2=mockStringList.get(1);


        // now we want to verify that the above method is called
        verify(mockStringList).get(0);


        // that the following function calls only one time
        // by default its one
        verify(mockStringList,times(2)).get(1);

        //at least once
        verify(mockStringList,atLeastOnce()).get(1);

        // at least twice
        verify(mockStringList,atLeast(2)).get(1);

        // at most
        verify(mockStringList,atMost(1)).get(0);

        // never
        verify(mockStringList,never()).get(8);
    }
}
