package br.com.sunty.dao;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.instructor.Instructor;

import javax.persistence.EntityManager;

public class SubCategoryDao {

    private EntityManager entityManager;

    public SubCategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(SubCategory subCategory) {
        this.entityManager.persist(subCategory);
    }

    public void update(SubCategory subCategory) {
        this.entityManager.merge(subCategory);
    }

    public void delete(SubCategory subCategory) {
        subCategory = entityManager.merge(subCategory);
        this.entityManager.remove(subCategory);
    }

    public SubCategory findById(Long id) {
        return entityManager.find(SubCategory.class, id);
    }
}
