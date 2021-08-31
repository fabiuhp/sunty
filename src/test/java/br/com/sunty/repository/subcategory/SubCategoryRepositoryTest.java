package br.com.sunty.repository.subcategory;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class SubCategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        Category categoryProgramacao = new CategoryBuilder("programacao", "programacao").build();
        Category categoryDevops = new CategoryBuilder("devops", "devops").build();
        Category categoryBusiness = new CategoryBuilder("business", "business").inactive().build();
        categoryRepository.save(categoryProgramacao);
        categoryRepository.save(categoryDevops);
        categoryRepository.save(categoryBusiness);

        SubCategory subCategoryAgil = new SubCategoryBuilder("Agil", "agil", categoryDevops).activate().build();
        SubCategory subCategoryJava = new SubCategoryBuilder("Java", "java", categoryProgramacao).activate().build();
        subCategoryRepository.save(subCategoryAgil);
        subCategoryRepository.save(subCategoryJava);

        Instructor gesley = new InstructorBuilder("Gesley").build();
        instructorRepository.save(gesley);

        Course courseJavaBasico = new CourseBuilder("Java basico", "java-basico", 4, gesley, subCategoryJava).publicVisibility().build();
        Course courseAgilBasico = new CourseBuilder("Agil basico", "agil-basico", 3, gesley, subCategoryAgil).publicVisibility().build();
        courseRepository.save(courseJavaBasico);
        courseRepository.save(courseAgilBasico);
    }

    @Test
    void shouldFindByUrlCode() {
        Optional<SubCategory> subCategory = subCategoryRepository.findByUrlCode("agil");

        assertThat(subCategory.isPresent())
                .isTrue();

        assertThat(subCategory.get())
                .extracting(SubCategory::getUrlCode)
                .isEqualTo("agil");
    }

    @Test
    void shouldNotFindByUrlCode() {
        assertThatThrownBy(() -> subCategoryRepository.findByUrlCode("erro")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    void shouldNotFindAllByCategoryUrlCode() {
        List<SubCategory> subCategories = subCategoryRepository.findAllByCategoryUrlCode("erro");

        assertThat(subCategories)
                .isEmpty();
    }

    @Test
    void shouldFindAllByCategoryUrlCode() {
        List<SubCategory> subCategories = subCategoryRepository.findAllByCategoryUrlCode("devops");

        assertThat(subCategories)
                .hasSize(1)
                .extracting(SubCategory::getUrlCode)
                .containsExactly("agil");
    }

}