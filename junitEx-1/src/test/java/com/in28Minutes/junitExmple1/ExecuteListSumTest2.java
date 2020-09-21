package com.in28Minutes.junitExmple1;

import com.in28Minutes.junitExmple1.component.ExecuteListSum;
import com.in28Minutes.junitExmple1.serviceImpl.ListSumServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExecuteListSumTest2 {

    int[] numbers=new int[]{1,2,3};

    @InjectMocks
    ExecuteListSum executeListSum;

    @Mock
    ListSumServiceImpl listSumService;

    @Test
    public void getSumTest(){
        Mockito.when(listSumService.calculateListSum(numbers))
                .thenReturn(6);

        int actualResult=executeListSum.getSum(numbers);

        assertEquals(6,actualResult);

        Mockito.verify(listSumService).calculateListSum(Mockito.any(int[].class));
    }

    @Test
    public  void getSizeTest(){
        Mockito.when(listSumService.listSumSize(numbers))
                .thenReturn(3);
        int actualResult=executeListSum.getLength(numbers);

        assertEquals(3,actualResult);

        Mockito.verify(listSumService).listSumSize(Mockito.any(int[].class));
    }

    @Test
    public void getFirstElement(){
        Mockito.when(listSumService.listSumGetFirst(numbers))
                .thenReturn(1);

        int actualResult=executeListSum.getFirstElement(numbers);

        assertEquals(1,actualResult);
        Mockito.verify(listSumService,Mockito.times(2)).listSumGetFirst(Mockito.any(int[].class));
    }

}
