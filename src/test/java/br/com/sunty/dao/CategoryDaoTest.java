package br.com.sunty.dao;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryBuilder;
import br.com.sunty.utils.JPAUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryDaoTest {

    private EntityManager entityManager;
    private CategoryDao categoryDao;

    @BeforeEach
    void setUp() {
        entityManager = JPAUtil.getEntityManager();
        categoryDao = new CategoryDao(entityManager);
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().rollback();
    }

    @Test
    void findAllActiveOrdered__should_return_active_categories_ordered_by_orderToShow() {
        createCategoryOrderedFirst();
        createCategoryOrderedSecond();
        createCategoryNotActive();
        List<Category> categories = categoryDao.findAllByiIsActiveIsTrueOrderByOrderToShowAsc();
        assertEquals(categories.size(), 2);
        assertEquals(categories.get(0).getUrlCode(), "categoria-teste-um");
        assertEquals(categories.get(1).getUrlCode(), "categoria-teste-dois");
    }

    private void createCategoryOrderedFirst() {
        Category category = new CategoryBuilder("Categoria de teste um", "categoria-teste-um")
                .withOrder(1)
                .activeCategory(true)
                .build();
        entityManager.persist(category);
    }

    private void createCategoryOrderedSecond() {
        Category category = new CategoryBuilder("Categoria de teste-dois", "categoria-teste-dois")
                .withOrder(2)
                .activeCategory(true)
                .build();
        entityManager.persist(category);
    }

    private void createCategoryNotActive() {
        Category category = new CategoryBuilder("Categoria de teste-tres", "categoria-teste-tres")
                .withOrder(3)
                .activeCategory(false)
                .build();
        entityManager.persist(category);
    }
}