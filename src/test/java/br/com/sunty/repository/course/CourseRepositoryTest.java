package br.com.sunty.repository.course;

import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

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
                .containsExactly(14, 1, 0);
    }

    @Test
    void findByUrlCode() {
        Course course = courseRepository.findByUrlCode("git-e-github-para-sobrevivencia")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        assertThat(course).isNotNull();
    }

    @Test
    void findAllBySubCategory_UrlCode() {
        PageRequest pageable = PageRequest.of(0, 5);
        Page<Course> courses = courseRepository.findAllBySubCategory_UrlCode("builds-e-controle-de-versao", pageable);
        List<Course> coursesList = courses.getContent();

        assertThat(coursesList)
                .isNotEmpty()
                .hasSize(1)
                .extracting(Course::getUrlCode)
                .containsExactly("git-e-github-para-sobrevivencia");

    }
}