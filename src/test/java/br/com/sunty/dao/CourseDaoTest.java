package br.com.sunty.dao;

import br.com.sunty.models.course.Course;
import br.com.sunty.utils.JPAUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoTest {

    EntityManager entityManager = JPAUtil.getEntityManager();

    @Test
    void shouldValidateAllPublicCourses() {
        CourseDao courseDao = new CourseDao(entityManager);
        List<Course> courses = courseDao.findAllPublic();
        assertEquals(courses.get(0).getUrlCode(), "git-e-github-para-sobrevivencia");
        assertEquals(courses.get(1).getUrlCode(), "java-jpa-consultas-avancadas-performance-modelos-complexos");
    }
}