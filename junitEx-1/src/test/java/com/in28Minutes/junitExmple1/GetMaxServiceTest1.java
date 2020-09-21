package com.in28Minutes.junitExmple1;

import com.in28Minutes.junitExmple1.serviceImpl.GetMaxService;
import com.in28Minutes.junitExmple1.repository.GetArrayRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class GetMaxServiceTest1 {

    @InjectMocks
    private GetMaxService getMaxService;

    @Mock
    private GetArrayRepository getArrayService;

    @Test
    public void maxElementIsTest(){
        Mockito.when(getArrayService.feedArray())
                .thenReturn(new int[]{10,20,30});

        int actualMax= getMaxService.maxElementIs();

        assertEquals(30,actualMax);
        Mockito.verify(getArrayService).feedArray();
    }

}
