package com.kavlord.teacher;

import com.kavlord.teacher.controller.DancerController;
import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.service.DancerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DancerTest {
    @Mock
    private DancerService dancerService;
    @InjectMocks
    private DancerController dancerController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(dancerController).build();
    }

    @Test
    public void testShowAllDancers() throws Exception{
        List<Dancer> dancers = new ArrayList<>();
        dancers.add(new Dancer());
        dancers.add(new Dancer());

        when(dancerService.findAll()).thenReturn(dancers);

        mockMvc.perform(get("/dancers"))
                .andExpect(status().isOk())
                .andExpect(view().name("dancers.html"))
                .andExpect(model().attribute("dancers", hasSize(2)));
    }
    @Test
    public void testUpdateDancerForm() throws Exception{
        Dancer dancer = new Dancer();

        when(dancerService.findById(any(Long.class))).thenReturn(Optional.of(dancer));

        mockMvc.perform(post("/dancers/update").param("id", "1")
                .flashAttr("dancer", dancer))
                .andExpect(status().isOk())
                .andExpect(view().name("dancerDetails"))
                .andExpect(model().attribute("isUpdating", true));
    }

}

