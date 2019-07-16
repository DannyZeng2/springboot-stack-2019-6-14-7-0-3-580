package com.tw.apistackbase;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tw.apistackbase.controller.Employees;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;


	@Test
	public void should_return_result_when_get_methon() throws Exception {
		String content = this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		JSONArray jsonArray = new JSONArray(content);
		Assertions.assertEquals(1,jsonArray.getJSONObject(0).getInt("id"));
		Assertions.assertEquals("Danny",jsonArray.getJSONObject(0).getString("name"));
		Assertions.assertEquals(18,jsonArray.getJSONObject(0).getInt("age"));
		Assertions.assertEquals("male",jsonArray.getJSONObject(0).getString("gender"));
	}



}
