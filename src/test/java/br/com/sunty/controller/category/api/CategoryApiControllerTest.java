package br.com.sunty.controller.category.api;

import br.com.sunty.models.category.Category;
import br.com.sunty.repository.category.CategoryBuilder;
import br.com.sunty.repository.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CategoryApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    void shouldFindAllActiveCategories() throws Exception {
        Category category = new CategoryBuilder("programacao", "programacao").build();
        categoryRepository.save(category);

        URI uri = new URI("/api/categories");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void clearCache() throws Exception {
        URI uri = new URI("/api/bGltcGEtby1jYWNoZS1kYS1hcGktYWU");

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}