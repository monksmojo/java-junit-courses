package com.in28Minutes.junitExmple1;

import com.in28Minutes.junitExmple1.serviceImpl.GetMaxService;
import com.in28Minutes.junitExmple1.repository.GetArrayRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = GetMaxService.class)
public class GetMaxServiceTest2 {

    @MockBean
    private GetArrayRepository getArrayService;

    @Autowired
    private GetMaxService getMaxService;



    @Test
    public void maxElementIsTest(){
        Mockito.when(getArrayService.feedArray())
                .thenReturn(new int[]{10,20,30});

        int actualMax= getMaxService.maxElementIs();

        assertEquals(30,actualMax);
        Mockito.verify(getArrayService).feedArray();
    }

}
