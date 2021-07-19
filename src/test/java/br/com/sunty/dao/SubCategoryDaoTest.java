package br.com.sunty.dao;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.utils.JPAUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubCategoryDaoTest {

    EntityManager entityManager = JPAUtil.getEntityManager();

    @Test
    void shouldValidateOrderOfActiveSubCategories() {
        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);
        List<SubCategory> subCategories = subCategoryDao.findAllActiveOrdered();
        assertEquals(subCategories.get(0).getUrlCode(), "java");
        assertEquals(subCategories.get(1).getUrlCode(), "builds-e-controle-de-versao");
        assertEquals(subCategories.get(2).getUrlCode(), "java-e-persistencia");
        assertEquals(subCategories.get(3).getUrlCode(), "php");
    }

    @Test
    void shouldValidateSubCategoriesWithoutDescription() {
        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);
        List<SubCategory> subCategories = subCategoryDao.withoutDescription();
        assertEquals(subCategories.get(0).getUrlCode(), "java-e-persistencia");
        assertEquals(subCategories.get(1).getUrlCode(), "cobol");
    }
}