package br.com.sunty.tests;

import br.com.sunty.dao.InstructorDao;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CreateInstructor {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        InstructorDao instructorDao = new InstructorDao(entityManager);

        List<Instructor> instructors = instructorDao.findAll();
        instructors.forEach(x -> System.out.println(x.getName()));

        Instructor instructor = new Instructor("Cadu");
        entityManager.getTransaction().begin();
        instructorDao.create(instructor);
        entityManager.getTransaction().commit();

        List<Instructor> newInstructors = instructorDao.findAll();
        newInstructors.forEach(x -> System.out.println(x.getName()));
        entityManager.close();
    }
}
