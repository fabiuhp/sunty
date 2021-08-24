package br.com.sunty.controller.category.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CategoryApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindAllActiveCategories() throws URISyntaxException {
        URI uri = new URI("/api/categories");

//        mockMvc.perform()
    }

    @Test
    void clearCache() {
    }
}