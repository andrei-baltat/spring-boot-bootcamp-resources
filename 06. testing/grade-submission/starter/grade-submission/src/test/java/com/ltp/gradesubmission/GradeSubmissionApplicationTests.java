package com.ltp.gradesubmission;

import com.ltp.gradesubmission.controller.GradeController;
import com.ltp.gradesubmission.pojo.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class GradeSubmissionApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(mockMvc);
	}

	@Test
	public void testShowGradeForm() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/?id=123");
		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful())
				.andExpect(view().name("form"))
				.andExpect(model().attributeExists("grade"));
	}

	public void testSubmitGrade() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.post("/submit")
				.param("name","harry")
				.param("subject","history")
				.param("subject","C-");

		mockMvc.perform(request)
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/grades"));
	}


	@Test
	public void unsuccessfulSubmition() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.post("/submit")
				.param("name","   ")
				.param("subject","    ")
				.param("subject","R-");

		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful())
				.andExpect(view().name("form"));

	}


	@Test
	public void testGrades() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/grades");

		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful())
				.andExpect(view().name("grades"))
				.andExpect(model().attributeExists("grades"));
	}


}
