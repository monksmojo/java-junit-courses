package com.in28minutes.junitmockito.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SpyTesting {
    @Test
    public void drawBacksOfMockTest(){
        // when we create a mock of a class or an interface it loss all its behaviour
        ArrayList<String> stringArrayList=mock(ArrayList.class);
        String aString = stringArrayList.get(0); //null
        int aInt = stringArrayList.size(); //0

        assertEquals(null,aString);
        assertEquals(0,aInt);


        // even after we do

        stringArrayList.add("hello1");
        stringArrayList.add("hello2");

        // it will still show
       aString= stringArrayList.get(0); // null
       aInt= stringArrayList.size();// 0
        assertEquals(null,aString);
        assertEquals(0,aInt);

       // because a mock does not retain behaviour or code of the original class

      // unless you stub it with when then you take control or override it
        when(stringArrayList.size()).thenReturn(5);
        assertEquals(5,stringArrayList.size());
    }

    @Test
    public void spyTest(){
        // when we create a spy of a class or an interface its behaviour gets intact
        ArrayList<String> stringArrayList=spy(ArrayList.class);

        // so now if we do

        stringArrayList.add("hello1");
        stringArrayList.add("hello2");

        // it will still show
        String aString= stringArrayList.get(0); // null
        int aInt= stringArrayList.size();// 0
        assertEquals("hello1",aString);
        assertEquals(2,aInt);

        // because a spy retain behaviour or code of the original class

        // unless you stub it with when then you take control or override it
        when(stringArrayList.size()).thenReturn(5);
        assertEquals(5,stringArrayList.size());

        verify(stringArrayList).add("hello1");

        // we use spy when we don't have the data of the underlying of the class
        // but wants to check how the data is flowing in the class
        // or whats reeally going on under the hood
    }

}
