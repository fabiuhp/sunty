package br.com.sunty.dao;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;

import javax.persistence.EntityManager;
import java.util.List;

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

    public Category findByUrlCode(String urlCode) {
        String jpql = "SELECT c FROM Category c where c.urlCode=:urlCode";
        return entityManager.createQuery(jpql, Category.class)
                .setParameter("urlCode", urlCode)
                .getSingleResult();
    }

    public List<Category> findAllByiIsActiveIsTrueOrderByOrderToShowAsc() {
        String jpql = "SELECT c FROM Category c where c.isActive=true order by c.orderToShow";
        return entityManager.createQuery(jpql, Category.class).getResultList();
    }

    public List<Category> findAll() {
        String jpql = "SELECT c FROM Category c";
        return entityManager.createQuery(jpql, Category.class).getResultList();
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }
}
