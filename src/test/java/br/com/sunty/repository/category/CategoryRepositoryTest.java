package br.com.sunty.repository.category;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.repository.course.CourseBuilder;
import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.instructor.InstructorBuilder;
import br.com.sunty.repository.instructor.InstructorRepository;
import br.com.sunty.repository.subcategory.SubCategoryBuilder;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CategoryRepositoryTest {

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
        String categoryName = "devops";
        Optional<Category> category = categoryRepository.findByUrlCode(categoryName);
        Optional<Category> category2 = categoryRepository.findByUrlCode("inexistente");

        assertThat(category.isPresent())
                .isTrue();
        assertThat(category.get())
                .extracting(Category::getName)
                .isEqualTo(categoryName);
        assertThat(category2.isEmpty())
                .isTrue();
    }

    @Test
    void shouldFindAllByActive() {
        List<Category> categories = categoryRepository.findAllByActive(true);
        List<Category> categoriesInactives = categoryRepository.findAllByActive(false);

        assertThat(categories)
                .hasSize(2)
                .extracting(Category::getUrlCode)
                .containsExactly("programacao", "devops");
        assertThat(categoriesInactives)
                .hasSize(1)
                .extracting(Category::getUrlCode)
                .containsExactly("business");
    }

    @Test
    void shouldFindAllByOrderByName() {
        List<Category> categories = categoryRepository.findAllByOrderByName();

        assertThat(categories)
                .hasSize(3)
                .extracting(Category::getUrlCode)
                .containsSequence("business", "devops", "programacao");
    }

    @Test
    void shouldFindActiveCategoriesWithActiveSubCategoriesAndPublicCourses() {
        List<Category> categories = categoryRepository.findActiveCategoriesWithActiveSubCategoriesAndPublicCourses();

        assertThat(categories)
                .hasSize(2)
                .extracting(Category::getUrlCode)
                .contains("devops", "programacao");
    }

    @Test
    void shouldFindCategoryActiveByUrlCode() {
        Optional<Category> activeCategory = categoryRepository.findCategoryActiveByUrlCode("programacao");

        assertThat(activeCategory.isPresent())
                .isTrue();
        assertThat(activeCategory.get())
                .extracting(Category::getUrlCode)
                .isEqualTo("programacao");
    }

    @Test
    void shouldNotFindCategoryActiveByUrlCode() {
        String inactiveCategory = "business";

        Optional<Category> category = categoryRepository.findCategoryActiveByUrlCode(inactiveCategory);

        assertThat(category.isEmpty())
                .isTrue();
    }
}