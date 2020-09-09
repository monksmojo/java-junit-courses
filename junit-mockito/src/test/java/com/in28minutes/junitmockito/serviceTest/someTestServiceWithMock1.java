package com.in28minutes.junitmockito.serviceTest;

import com.in28minutes.junitmockito.data.SomeDataImpl;
import com.in28minutes.junitmockito.service.SomeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// refined
public class someTestServiceWithMock1 {


    SomeServiceImpl someService=new SomeServiceImpl();

    SomeDataImpl someDataMock=mock(SomeDataImpl.class);


    @BeforeEach
    public void beforeRunningEachTest(){

        someService.setSomeData(someDataMock);
    }

    @Test
    public void testingWithMockForNormalInput() {

        when(someDataMock.retrieveData()).thenReturn(new int[] {1, 2, 3, 4});

        assertEquals(10, someService.calculateSumWithDataService());
    }

    @Test
    public void testingWithMockForNoInput(){
        when(someDataMock.retrieveData()).thenReturn(new int[]{});

        assertEquals(0,someService.calculateSumWithDataService());
    }

    @Test
    public  void testingWithMockForSingleInput(){
        when(someDataMock.retrieveData()).thenReturn(new int[]{5});

        assertEquals(5,someService.calculateSumWithDataService());
    }
}
