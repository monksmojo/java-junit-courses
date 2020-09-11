package com.in28minutes.junitmockito.serviceTest;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class MockListVerifyArgumentPassedTest {

    @Test
    public void argumentCatcherTest() {
        List<String> mockStringList = mock(List.class);
        // SUT -- system under test..
        mockStringList.add("String1");

        // now we want to verify that the above argument "String 1" is passed in the method
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockStringList).add(captor.capture());
        assertEquals("String1", captor.getValue());
    }


    /**
     * Use it to capture argument values for further assertions.
     *
     * <p>
     * Mockito verifies argument values in natural java style: by using an equals() method.
     * This is also the recommended way of matching arguments because it makes tests clean & simple.
     * In some situations though, it is helpful to assert on certain arguments after the actual verification.
     * For example:
     * <pre class="code"><code class="java">
     *   ArgumentCaptor&lt;Person&gt; argument = ArgumentCaptor.forClass(Person.class);
     *   verify(mock).doSomething(argument.capture());
     *   assertEquals("John", argument.getValue().getName());
     * </code></pre>
     *
     * Example of capturing varargs:
     * <pre class="code"><code class="java">
     *   //capturing varargs:
     *   ArgumentCaptor&lt;Person&gt; varArgs = ArgumentCaptor.forClass(Person.class);
     *   verify(mock).varArgMethod(varArgs.capture());
     *   List expected = asList(new Person("John"), new Person("Jane"));
     *   assertEqual
     */
    @Test
    public void multipleArgumentCaptureTest(){
        List<String> mockStringList=mock(List.class);
        mockStringList.add("hello0");
        mockStringList.add("hello1");

        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);

        // since verify by default checks that the method is called only once.
        // that's why we use times to make it work when it runs more than two times
        verify(mockStringList,times(2)).add(captor.capture());

        List<String> stringList=captor.getAllValues();

        assertEquals("hello0",stringList.get(0));
        assertEquals("hello1",stringList.get(1));
    }

}
