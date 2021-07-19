package br.com.sunty.dao;

import br.com.sunty.models.category.SubCategory;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<SubCategory> findAllActiveOrdered() {
        String jpql = "SELECT s FROM SubCategory s where s.isActive=true order by s.orderToShow";
        return entityManager.createQuery(jpql, SubCategory.class).getResultList();
    }

    public List<SubCategory> withoutDescription() {
        String jpql = "SELECT s FROM SubCategory s where s.shortDescription='' OR s.shortDescription IS NULL";
        return entityManager.createQuery(jpql, SubCategory.class).getResultList();
    }
}
