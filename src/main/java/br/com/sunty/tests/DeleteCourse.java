package br.com.sunty.tests;

import br.com.sunty.dao.CourseDao;
import br.com.sunty.models.course.Course;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DeleteCourse {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CourseDao courseDao = new CourseDao(entityManager);

        entityManager.getTransaction().begin();
        Course deleteCourse = courseDao.findById(5L);
        courseDao.delete(deleteCourse);
        entityManager.getTransaction().commit();

        List<Course> courses = courseDao.findAll();
        courses.forEach(x -> System.out.println("Id: " + x.getId() +", Name: " + x.getName()));
        entityManager.close();
    }
}
