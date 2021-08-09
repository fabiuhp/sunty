package br.com.sunty.dao;

import br.com.sunty.models.course.Course;

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

    public List<Course> findAll() {
        String jpql = "SELECT c FROM Course c";
        return entityManager.createQuery(jpql, Course.class).getResultList();
    }

    public List<Course> findAllByVisibilityIsPublic() {
        String jpql = "SELECT c FROM Course c where c.visibility='PUBLICA'";
        return entityManager.createQuery(jpql, Course.class).getResultList();
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }
}
