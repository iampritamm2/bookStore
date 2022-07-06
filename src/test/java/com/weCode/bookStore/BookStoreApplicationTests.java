package com.weCode.bookStore;

import com.weCode.bookStore.controller.fileUpload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BookStoreApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Test
	public void whenFileUploaded_thenVerifyStatus()
			throws Exception {
		MockMultipartFile file
				= new MockMultipartFile(
				"file",
				"hello.txt",
				MediaType.TEXT_PLAIN_VALUE,
				"Hello, World!".getBytes()
		);

		MockMvc mockMvc
				= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(multipart("/upload").file(file))
				.andExpect(status().isOk());
	}

	@Test
	public void whenFileUploaded_thenVerifyStatus2()
			throws Exception {
		MockMultipartFile file
				= new MockMultipartFile(
				"file",
				"hello.png",
				MediaType.TEXT_PLAIN_VALUE,
				"".getBytes()
		);

		MockMvc mockMvc
				= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		mockMvc.perform(multipart("/upload").file(file))
				.andExpect(status().is5xxServerError());
	}



}