package com.numbersapp.number.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.numbersapp.number.NumberServiceApplication;
import com.numbersapp.number.common.OrderType;
import com.numbersapp.number.dto.converter.NumberConverter;
import com.numbersapp.number.dto.domain.NumberDTO;
import com.numbersapp.number.service.impl.NumberAggregateService;
import com.numbersapp.number.service.impl.NumberCrudService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sepulrator on 08.07.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NumberServiceApplication.class)
@WebAppConfiguration
public class NumberControllerTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @InjectMocks
    private NumberController numberController;

    @Mock
    private NumberCrudService numberCrudService;

    @Mock
    private NumberAggregateService numberAggregateService;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(numberController).build();
    }

    @Test
    public void testInsertNumber() throws Exception {

        final NumberDTO numberDTO = new NumberDTO();
        numberDTO.setNumber((long) 1);
        String json = mapper.writeValueAsString(numberDTO);

        when(numberCrudService.read(numberDTO.getNumber())).thenReturn(numberDTO);

        mockMvc.perform(post("/numbers")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteNumber() throws Exception {

        final NumberDTO numberDTO = new NumberDTO();
        numberDTO.setNumber((long) 1);
        String json = mapper.writeValueAsString(numberDTO);

        doNothing().when(numberCrudService).delete(numberDTO.getNumber());

        mockMvc.perform(delete("/numbers/" + numberDTO.getNumber())
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testListNumber() throws Exception {

        final List<NumberDTO> numberDTOList = new ArrayList<NumberDTO>(2);
        final NumberDTO numberDTO1 = new NumberDTO();
        final NumberDTO numberDTO2 = new NumberDTO();
        numberDTO1.setNumber((long) 1);
        numberDTO2.setNumber((long) 2);
        numberDTOList.add(numberDTO1);
        numberDTOList.add(numberDTO2);


        when(numberCrudService.getList(OrderType.ASCENDING)).thenReturn(numberDTOList);

        mockMvc.perform(get("/numbers")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].number").value(numberDTO1.getNumber().intValue()))
                .andExpect(jsonPath("$[1].number").value(numberDTO2.getNumber().intValue()));
    }


    @Test
    public void testGetNumber() throws Exception {
        final NumberDTO numberDTO = new NumberDTO();
        numberDTO.setNumber((long) 10);

        when(numberCrudService.read(numberDTO.getNumber())).thenReturn(numberDTO);

        mockMvc.perform(get("/numbers/" + numberDTO.getNumber())).andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(numberDTO.getNumber().intValue()));

    }

    @Test
    public void testMaxNumber() throws Exception {
        final NumberDTO numberDTO = new NumberDTO();
        numberDTO.setNumber(Long.MAX_VALUE);

        when(numberAggregateService.getMaxEntity()).thenReturn(numberDTO);

        mockMvc.perform(get("/numbers/max")).andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(numberDTO.getNumber()));

    }

    @Test
    public void testMinNumber() throws Exception {
        final NumberDTO numberDTO = new NumberDTO();
        numberDTO.setNumber(Long.MIN_VALUE);

        when(numberAggregateService.getMinEntity()).thenReturn(numberDTO);

        mockMvc.perform(get("/numbers/min")).andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(numberDTO.getNumber()));

    }


}
