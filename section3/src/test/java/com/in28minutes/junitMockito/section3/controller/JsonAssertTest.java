package com.in28minutes.junitMockito.section3.controller;


import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;


import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class JsonAssertTest {
    String actualResponse="{\"itemId\":41,\"itemName\":\"Ball\",\"itemQuantity\":7,\"itemPrice\":10.25}";

    @Test
    public void jsonAssert_strictTrue_spaceAllowed() throws JSONException {
        String expectedResponse="{\"itemId\":41,\"itemName\":\"Ball\",\"itemQuantity\":7,\"itemPrice\":10.25}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    @Test
    public void jsonAssert_strictFalse_spaceAllowed() throws JSONException {
        String expectedResponse="{itemId :41,itemName:Ball,itemQuantity:7}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }

    @Test
    public void assertThatTest(){
        List<Integer> arrayIntegers = Arrays.asList(1,2,3);
        assertThat(arrayIntegers,hasItems(1));
    }
}
