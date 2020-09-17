package com.in28minutes.junitMockito.section3.controller;




import com.in28minutes.junitMockito.section3.entity.Item;
import com.in28minutes.junitMockito.section3.service.ItemService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// ItemController test using @Mock @InjectMock

@ExtendWith(MockitoExtension.class)
public class ItemControllerTest1 {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    ItemController itemController;

    @Mock
    ItemService itemService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getItemByServiceTest() throws Exception {
//        when(itemService.getOneItemByService()).thenReturn(new Item(21l,"sanitizer",5,10.00));

        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/item/get-one-by-service")
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"itemId\":21,\"itemName\":\"sanitizer\",\"itemQuantity\":5 }",false));
    }


}
