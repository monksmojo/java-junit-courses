package com.in28Minutes.junitExmple3.controller;

import com.in28Minutes.junitExmple3.model.Project;
import com.in28Minutes.junitExmple3.service.ProjectService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ProjectController.class)
@Log4j2
public class ProjectControllerTest {

    @MockBean
    private ProjectService projectServiceMock;

    @Autowired
    private MockMvc mockMvc;

    Project project=new Project(5L,"cloud","cloudLeader",2);

    @Test
    public void testProject() throws Exception {
        mockMvc.perform(get("/project/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("testing controller"));
    }

    @Test
    public void testGetProject() throws Exception {
        Mockito.when(projectServiceMock.getProject(Mockito.any(Long.class)))
                .thenReturn(project);

        RequestBuilder requestBuilder= get("/project/get/{contentId}",5L)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"projectName\": \"cloud\",\n" +
                        "    \"projectOwner\": \"cloudLeader\",\n" +
                        "    \"teamSize\": 2,\n" +
                        "    \"projectId\": 5\n" +
                        "}"));

        Mockito.verify(projectServiceMock).getProject(Mockito.any(Long.class));
    }

    @Test
    public void testSaveProject() throws Exception {
        Mockito.when(projectServiceMock.saveProject(project))
                .thenReturn(true);
        RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/project/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"projectName\":\"cloud\",\"projectOwner\":\"alan\",\"teamSize\":17,\"projectId\":5}")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult =mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated()).andReturn();

        log.info(mvcResult.getResponse().getStatus());
        log.info(mvcResult.getResponse().getContentAsString());

        Mockito.verify(projectServiceMock).saveProject(Mockito.any(Project.class));



//        assertEquals(HttpStatus.CREATED.value(),mvcResult.getResponse().getStatus());
    }
}
