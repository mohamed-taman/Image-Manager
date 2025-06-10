package com.taman.image.manager.api.controller;

import com.taman.image.manager.service.ImageManagementService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.taman.image.manager.util.ImageDataGenerator.newImageResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ImageManagementController.class)
class ImageManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ImageManagementService imageMgmtService;

    @Test
    void contextLoads() {
        assertThat(this.imageMgmtService).isNotNull();
        assertThat(this.mockMvc).isNotNull();
    }

    @Test
    void findAllImagesTest() throws Exception {
        var imageResponse = newImageResponse();

        // Given
        given(imageMgmtService.getAllImages()).willReturn(List.of(imageResponse));

        //When
        mockMvc.perform(get("/images") // Exact match with @RequestMapping of the controller
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].id", Matchers.is(imageResponse.id())))
                .andExpect(jsonPath("$[0].name", Matchers.is(imageResponse.name())));
    }

}