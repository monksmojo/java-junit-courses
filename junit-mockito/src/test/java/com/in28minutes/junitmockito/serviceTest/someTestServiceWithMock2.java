package com.in28minutes.junitmockito.serviceTest;

import com.in28minutes.junitmockito.data.SomeDataImpl;
import com.in28minutes.junitmockito.service.SomeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class someTestServiceWithMock2 {


    @InjectMocks
    SomeServiceImpl someService;

    @Mock
    SomeDataImpl someDataMock;

    /*
    the above loc 21 and 24
    @Mock will create the for the class SomeDataImpl someDataMock;
    @InjectMocks tells that the @Mock will be injected to this class i.e
    a instance of SomeDataImpl someDataMock will be injected to SomeServiceImpl
    i.e it will call the setter in SomeServiceImpl
     */


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
