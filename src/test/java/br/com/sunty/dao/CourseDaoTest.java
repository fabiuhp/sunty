package br.com.sunty.dao;

import br.com.sunty.models.InstructorBuilder;
import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryBuilder;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.category.SubCategoryBuilder;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseBuilder;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.utils.JPAUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseDaoTest {

    private EntityManager entityManager;
    private CourseDao courseDao;
    private Instructor instructor;
    private Category category;
    private SubCategory subCategory;

    @BeforeEach
    void setUp() {
        entityManager = JPAUtil.getEntityManager();
        courseDao = new CourseDao(entityManager);
        entityManager.getTransaction().begin();
        createInstructor();
        createCategory();
        createSubCategory();
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().rollback();
    }

    void createOneCoursePublic() {
        Course course = new CourseBuilder("Curso 2", "curso-dois", 10, instructor, subCategory)
                .withVisibility(CourseVisibility.PUBLICA)
                .build();
        entityManager.persist(course);
    }

    void createOneCoursePrivate() {
        Course course = new CourseBuilder("Curso 1", "curso-um", 10, instructor, subCategory)
                .withVisibility(CourseVisibility.PRIVADA)
                .build();
        entityManager.persist(course);
    }

    @Test
    void shouldValidateAllPublicCourses() {
        createOneCoursePublic();
        createOneCoursePrivate();
        List<Course> courses = courseDao.findAllByVisibilityIsPublic();
        assertEquals(1, courses.size());
    }

    private void createSubCategory() {
        subCategory = new SubCategoryBuilder("SubCategoria de teste", "subcat-teste-novo", category)
                .withOrderToShow(5)
                .build();
        entityManager.persist(subCategory);
    }

    private void createCategory() {
        category = new CategoryBuilder("Categoria de teste", "categoria-teste").build();
        entityManager.persist(category);
    }

    private void createInstructor() {
        instructor = new InstructorBuilder("Gesley").build();
        entityManager.persist(instructor);
    }
}