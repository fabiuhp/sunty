package br.com.sunty.tests;

import br.com.sunty.dao.CourseDao;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UpdateCourse {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CourseDao courseDao = new CourseDao(entityManager);

        entityManager.getTransaction().begin();
        List<Course> courseList = courseDao.findAll();
        courseList.forEach(x -> x.setVisibility(CourseVisibility.PUBLICA));

        for (Course course: courseList) {
            courseDao.update(course);
        }

        entityManager.getTransaction().commit();

        List<Course> courses = courseDao.findAll();
        courses.forEach(x -> System.out.println(x.getVisibility()));
        entityManager.close();
    }
}
