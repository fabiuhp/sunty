package br.com.sunty.dao;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryBuilder;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.category.SubCategoryBuilder;
import br.com.sunty.utils.JPAUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubCategoryDaoTest {

    private EntityManager entityManager;
    private Category category;
    private SubCategoryDao subCategoryDao;

    @BeforeEach
    void setUp() {
        entityManager = JPAUtil.getEntityManager();
        subCategoryDao = new SubCategoryDao(entityManager);
        entityManager.getTransaction().begin();
        createCategory();
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().rollback();
    }

    @Test
    void shouldValidateOrderOfActiveSubCategories() {
        createSubCategoryActive();
        createSubCategoryActiveWithoutDescription();
        createSubCategoryInactiveWithDescription();

        List<SubCategory> subCategories = subCategoryDao.findAllByIsActiveIsTrueOrderByOrderToShowAsc();
        assertEquals(2, subCategories.size());
        assertEquals(subCategories.get(0).getUrlCode(), "subcategoria-um");
        assertEquals(subCategories.get(1).getUrlCode(), "subcategoria-dois");
    }

    @Test
    void shouldValidateSubCategoriesWithoutDescription() {
        createSubCategoryActive();
        createSubCategoryActiveWithoutDescription();

        List<SubCategory> subCategories = subCategoryDao.withoutDescription();
        assertEquals(1, subCategories.size());
        assertEquals(subCategories.get(0).getUrlCode(), "subcategoria-dois");
    }

    private void createCategory() {
        category = new CategoryBuilder("Categoria de teste um", "categoria-teste-um")
                .withOrder(1)
                .activeCategory()
                .build();
        entityManager.persist(category);
    }

    private void createSubCategoryActive() {
        SubCategory subCategory = new SubCategoryBuilder("SubCategoria um", "subcategoria-um", category)
                .active()
                .withOrderToShow(1)
                .withDescription("descricao subcategoria um")
                .build();
        entityManager.persist(subCategory);
    }

    private void createSubCategoryActiveWithoutDescription() {
        SubCategory subCategory = new SubCategoryBuilder("SubCategoria dois", "subcategoria-dois", category)
                .active()
                .withOrderToShow(2)
                .build();
        entityManager.persist(subCategory);
    }

    private void createSubCategoryInactiveWithDescription() {
        SubCategory subCategory = new SubCategoryBuilder("SubCategoria tres", "subcategoria-tres", category)
                .inactive()
                .withOrderToShow(3)
                .withDescription("descricao subcategoria tres")
                .build();
        entityManager.persist(subCategory);
    }
}