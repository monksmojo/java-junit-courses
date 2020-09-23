package com.in28Minutes.junitExmple2;

import com.in28Minutes.junitExmple2.controller.TransactionController;
import com.in28Minutes.junitExmple2.model.Transaction;
import com.in28Minutes.junitExmple2.service.TransactionService;
import com.in28Minutes.junitExmple2.service.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;


@WebMvcTest(value = TransactionController.class)
public class TransactionTest1 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionServiceImpl transactionService;

    static Transaction transaction=new Transaction(4046l,4080l,1000.00);

    @Test
    public void testSendMoney() throws Exception {
        Mockito.when(transactionService.transactionProcess(Mockito.any(Transaction.class))).thenReturn(true);
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/send-money")
                .queryParam("toAccountId","4046")
                .queryParam("fromAccountId","4080")
                .queryParam("amount","1000.00")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result =mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        Mockito.verify(transactionService,Mockito.times(1)).transactionProcess(Mockito.any(Transaction.class));

    }
}
