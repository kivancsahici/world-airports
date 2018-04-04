package com.acme.airports.test.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AirportServiceTests {
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void getReport() throws Exception {

       this.mockMvc.perform(get("/report")).andDo(print()).andExpect(status().isOk())
       //test response structure
       .andExpect(jsonPath("$.max").isArray()).andExpect(jsonPath("$.min").isArray())
       //test response content
       .andExpect(jsonPath("$.max[0].id").value("21501")).andExpect(jsonPath("$.max[0].name").value("United States"))
       .andExpect(jsonPath("$.max[0].runwayIdentifications").value("H1, 18, 9, 17, 16, 13, 8, 14, 15, 1"))
       .andExpect(jsonPath("$.max[1].id").value("3839")).andExpect(jsonPath("$.max[1].name").value("Brazil"))
       .andExpect(jsonPath("$.max[1].runwayIdentifications").value("9, 18, 3, 12, 2, 6, 1, 7, 11, 10"))
       .andExpect(jsonPath("$.max[1].runwayTypes").value("GVL, GRVL/PIÇ, ASP, CON, ASPH, TER, CONC/MTAL, PIÇ, GRVL, GRE, CON/ASP, CON/GRS, SAND, ASP/GRE, MET, CONC, GRS, GRASS, GRAVEL, SAI, ASPHALT, GRV, MTAL, GRE/GRS, UNK, WOOD, MET/CON, PIC, CON/MET, ASP/GRS, ARG"));
    }
	
	@Test
    public void findAll() throws Exception {

       this.mockMvc.perform(get("/countries")).andDo(print()).andExpect(status().isOk())
       //test response structure
       .andExpect(jsonPath("$").isArray())
       //test response size
       .andExpect(jsonPath("$", hasSize(247)))
       //test response content
       .andExpect(jsonPath("$.[0].code").value("AD"))
       .andExpect(jsonPath("$.[0].name").value("Andorra"))
       .andExpect(jsonPath("$.[246].code").value("ZZ"))
       .andExpect(jsonPath("$.[246].name").value("Unknown or unassigned country"));
    }
	

	@Test
    public void findByName() throws Exception {
		this.mockMvc.perform(get("/countries/Netherlands")).andDo(print()).andExpect(status().isOk())
		//test response content
		.andExpect(jsonPath("$.code").value("NL"))
		.andExpect(jsonPath("$.name").value("Netherlands"))
		.andExpect(jsonPath("$.airports").isArray())
		.andExpect(jsonPath("$..airports[?(@.id==2527)].name").value("Valkenburg Naval Air Base"))
		.andExpect(jsonPath("$..airports[?(@.id==2527)].runways").isArray())
		.andExpect(jsonPath("$..airports[?(@.id==2527)].runways[0].surface").value("ASP"))
		.andExpect(jsonPath("$..airports[?(@.id==2527)].runways[1].airport_ident").value("EHVB"))
		;       
    }

}
