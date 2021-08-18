package br.com.sunty.repository.category;

import br.com.sunty.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByUrlCode(String urlCode);

    List<Category> findAllByIsActive(boolean active);

    List<Category> findAllByOrderByName();

    @Query(value = """
            select distinct c from Category c
            join c.subCategoryList sc join sc.courseList course
            where c.isActive = true and sc.isActive = true and course.visibility = 'PUBLICA'
            order by c.orderToShow
            """)
    List<Category> findAllActiveCategoriesWhereCategoryIsActiveAndCourseVisibilityIsTrueAndSubCategoryIsActive();
}
