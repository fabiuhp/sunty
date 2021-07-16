package br.com.sunty.dao;

import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDao {

    private EntityManager entityManager;

    public CourseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Course course) {
        this.entityManager.persist(course);
    }

    public void update(Course course) {
        this.entityManager.merge(course);
    }

    public void delete(Course course) {
        course = entityManager.merge(course);
        this.entityManager.remove(course);
    }

    public List<Course> findAll() {
        String jpql = "SELECT c FROM Course c";
        return entityManager.createQuery(jpql, Course.class).getResultList();
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }
}
