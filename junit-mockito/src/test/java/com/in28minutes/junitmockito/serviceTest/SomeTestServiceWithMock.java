package com.in28minutes.junitmockito.serviceTest;

import com.in28minutes.junitmockito.data.SomeDataImpl;
import com.in28minutes.junitmockito.service.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SomeTestServiceWithMock {
    @Autowired
    SomeServiceImpl someService;

    @Test
    public void testingWithMockForNormalInput(){

        /*
         * instead of creating stub to generate some data
         * we used mockito frame work to programmatically generate data
         * according to condition
         */



        /*
         * so we called mock method of mockito framework from
         * import static org.mockito.Mockito.mock;
         * to create mock of a class or an interface
         */

        SomeDataImpl someDataMock=mock(SomeDataImpl.class);
        /*
         *  and we use when method present in
         * import static org.mockito.Mockito.when
         * which will generate data programmatically
         * so when the mock class or interface method is called
         * for example someDataMock.retrieveData()
         * return the values thenReturn(new int[]{1,2,3,4})
         */
        when(someDataMock.retrieveData()).thenReturn(new int[]{1,2,3,4});

        someService.setSomeData(someDataMock);

        int actualResult=someService.calculateSumWithDataService();
        int expectedResult=10;
        assertEquals(expectedResult,actualResult);

    }
}
