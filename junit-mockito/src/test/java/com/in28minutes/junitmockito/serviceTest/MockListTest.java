package com.in28minutes.junitmockito.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MockListTest {
    @Test
    public void mockListSizeTest(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(5);
        assertEquals(5,listMock.size());
    }

    @Test
    public void mockListMultipleSizeTest(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,listMock.size());
        assertEquals(10,listMock.size());
    }

    @Test
    public void mockListParameterTest(){
        List listMock=mock(List.class);
        when(listMock.get(0)).thenReturn("0 index is called");
        assertEquals("0 index is called",listMock.get(0));
        assertEquals(null,listMock.get(1));
    }

    @Test
    public void mockListGenericParameterTest(){
        List listMock=mock(List.class);
        when(listMock.get(anyInt())).thenReturn("0 index is called");
        assertEquals("0 index is called",listMock.get(0));
        assertEquals(null,listMock.get(1));
    }
}
