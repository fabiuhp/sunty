package br.com.sunty.controller.category.api;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.repository.category.CategoryBuilder;
import br.com.sunty.repository.category.CategoryRepository;
import br.com.sunty.repository.course.CourseBuilder;
import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.instructor.InstructorBuilder;
import br.com.sunty.repository.instructor.InstructorRepository;
import br.com.sunty.repository.subcategory.SubCategoryBuilder;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;

import static org.hamcrest.Matchers.hasSize;
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

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    @Transactional
    void shouldFindAllActiveCategoriesJson() throws Exception {
        Category category = new CategoryBuilder("programacao", "programacao").build();
        categoryRepository.save(category);

        SubCategory subCategoryAgil = new SubCategoryBuilder("Agil", "agil", category).activate().build();
        subCategoryRepository.save(subCategoryAgil);

        Instructor gesley = new InstructorBuilder("Gesley").build();
        instructorRepository.save(gesley);

        Course courseJavaBasico = new CourseBuilder("Java basico", "java-basico", 4, gesley, subCategoryAgil).publicVisibility().build();
        courseRepository.save(courseJavaBasico);

        URI uri = new URI("/api/categories");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].urlCode").value("programacao"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[0].urlCode").value("agil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[0].courses", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[0].courses[0].urlCode").value("java-basico"))
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