package br.com.sunty.dao;

import br.com.sunty.models.instructor.Instructor;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorDao {

    private EntityManager entityManager;

    public InstructorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    public List<Instructor> findAll() {
        String jpql = "SELECT i FROM Instructor i";
        return entityManager.createQuery(jpql, Instructor.class).getResultList();
    }

    public Instructor findById(Long id) {
        return entityManager.find(Instructor.class, id);
    }
}
