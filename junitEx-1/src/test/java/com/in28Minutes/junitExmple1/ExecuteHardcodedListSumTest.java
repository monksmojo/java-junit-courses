package com.in28Minutes.junitExmple1;

import com.in28Minutes.junitExmple1.component.ExecuteListSum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(SpringExtension.class)
public class ExecuteHardcodedListSumTest {

    ExecuteListSum executeListSum=new ExecuteListSum();

    @BeforeAll
    static void beforeAll(){
        log.info("call once before execution of test class ExecuteListSum Test");
    }

    @BeforeEach
    void beforeEach(){
        log.info("call every time before execution of test method");
    }

    @Test
    void testSum(){
        int actualResult=executeListSum.getHardcodedSum(new int[]{1,2,3});
        assertEquals(6,actualResult);
    }

    @Test
    void getLength(){
        int actualResult=executeListSum.getHardcodedLength(new int[]{1,2,3});
        assertEquals(3,actualResult);
    }

    @Test
    void getFirstElement(){
        int actualFirstElement=executeListSum.getFirstHardcodedElement(new int[]{1,2,3,4});
        assertEquals(1,actualFirstElement);
    }

    @AfterAll
    static void afterAll(){
        log.info("call once after execution of test class ExecuteListSum Test");
    }

    @AfterEach
    void afterEach(){
        log.info("call every time after execution of test method");
    }
}
