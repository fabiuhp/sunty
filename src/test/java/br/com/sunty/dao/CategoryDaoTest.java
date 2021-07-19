package br.com.sunty.dao;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.utils.JPAUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import java.util.List;

class CategoryDaoTest {

    EntityManager entityManager = JPAUtil.getEntityManager();

    @Test
    void shouldValidateOrderOfActiveCategories() {
        CategoryDao categoryDao = new CategoryDao(entityManager);
        List<Category> categories = categoryDao.findAllActiveOrdered();
        assertEquals(categories.get(0).getUrlCode(), "programacao");
        assertEquals(categories.get(1).getUrlCode(), "devops");
    }
}