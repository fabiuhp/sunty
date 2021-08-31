package br.com.sunty.repository.course;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseProjection;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.repository.category.CategoryBuilder;
import br.com.sunty.repository.category.CategoryRepository;
import br.com.sunty.repository.instructor.InstructorBuilder;
import br.com.sunty.repository.instructor.InstructorRepository;
import br.com.sunty.repository.subcategory.SubCategoryBuilder;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
class CourseRepositoryTest {

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
    void shouldFindNameOfCategoriesWithNumberOfCourses() {
        List<CourseProjection> courseProjections = courseRepository.categoriesWithNumberOfCourses();

        assertThat(courseProjections)
                .hasSize(3)
                .extracting(CourseProjection::getName)
                .containsExactly("programacao", "devops", "business");
    }

    @Test
    void shouldFindCoursesQuantitiesOfCategoriesWithNumberOfCourses() {
        List<CourseProjection> courseProjections = courseRepository.categoriesWithNumberOfCourses();

        assertThat(courseProjections)
                .hasSize(3)
                .extracting(CourseProjection::getCoursesquantity)
                .containsExactly(1, 1, 0);
    }

    @Test
    void findByUrlCode() {
        Optional<Course> course = courseRepository.findByUrlCode("agil-basico");
        assertThat(course.isPresent())
                .isTrue();

        assertThat(course.get())
                .extracting(Course::getUrlCode)
                .isEqualTo("agil-basico");
    }

    @Test
    void shouldNotFindByUrlCode() {
        assertThatThrownBy(() -> courseRepository.findByUrlCode("erro")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    void findAllBySubCategory_UrlCode() {
        PageRequest pageable = PageRequest.of(0, 5);
        Page<Course> courses = courseRepository.findAllBySubCategory_UrlCode("agil", pageable);
        List<Course> coursesList = courses.getContent();

        assertThat(coursesList)
                .isNotEmpty()
                .hasSize(1)
                .extracting(Course::getUrlCode)
                .containsExactly("agil-basico");

    }

    @Test
    void NotFindAllBySubCategory_UrlCode() {
        PageRequest pageable = PageRequest.of(0, 5);
        Page<Course> courses = courseRepository.findAllBySubCategory_UrlCode("erro", pageable);
        List<Course> coursesList = courses.getContent();

        assertThat(coursesList)
                .isEmpty();
    }
}
