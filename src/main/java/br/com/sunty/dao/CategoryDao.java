package br.com.sunty.dao;

import br.com.sunty.models.category.Category;

import javax.persistence.EntityManager;

public class CategoryDao {

    private EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Category category) {
        this.entityManager.persist(category);
    }

    public void update(Category category) {
        this.entityManager.merge(category);
    }

    public void delete(Category category) {
        category = entityManager.merge(category);
        this.entityManager.remove(category);
    }
}
