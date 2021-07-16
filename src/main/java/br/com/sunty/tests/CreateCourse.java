package br.com.sunty.tests;

import br.com.sunty.dao.CourseDao;
import br.com.sunty.dao.InstructorDao;
import br.com.sunty.dao.SubCategoryDao;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.CourseDto;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CreateCourse {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CourseDao courseDao = new CourseDao(entityManager);
        InstructorDao instructorDao = new InstructorDao(entityManager);
        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);
        Instructor cadu = instructorDao.findById(3L);
        SubCategory java = subCategoryDao.findById(1L);

        entityManager.getTransaction().begin();
        Course course = new Course("Curso ACME", "acme-course", 1, cadu, java);
        courseDao.create(course);
        entityManager.getTransaction().commit();

        List<Course> courses = courseDao.findAll();
        courses.forEach(x -> System.out.println(x.getName()));
        entityManager.close();
    }
}
