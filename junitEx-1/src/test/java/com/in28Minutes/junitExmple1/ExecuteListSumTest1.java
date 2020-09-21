package com.in28Minutes.junitExmple1;

import com.in28Minutes.junitExmple1.component.ExecuteListSum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExecuteListSumTest1 {



    ExecuteListSum executeListSumMock=Mockito.mock(ExecuteListSum.class);

    @Test
    public void getHardcodedSumTest(){
        when(executeListSumMock.getHardcodedSum(new int[]{1,2,3}))
                .thenReturn(6);
        assertEquals(6,executeListSumMock.getHardcodedSum(new int[]{1,2,3}));

        // checking weather the method is called or not
        Mockito.verify(executeListSumMock).getHardcodedSum(Mockito.any(int[].class));

    }

    @Test
    public void getHardcodedLengthTest(){
        when(executeListSumMock.getHardcodedLength(new int[]{1,2,3,}))
                .thenReturn(3);

        assertEquals(3,executeListSumMock.getHardcodedLength(new int[]{1,2,3,}));

        Mockito.verify(executeListSumMock).getHardcodedLength(Mockito.any(int[].class));
    }

    @Test
    public void getHardcodedFirstElement(){
        when(executeListSumMock.getFirstHardcodedElement(new int[]{1,2,3,}))
                .thenReturn(1);

        assertEquals(1,executeListSumMock.getFirstHardcodedElement(new int[]{1,2,3,}));

        Mockito.verify(executeListSumMock).getHardcodedSum(Mockito.any(int[].class));
    }


}
