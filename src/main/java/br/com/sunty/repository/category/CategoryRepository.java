package br.com.sunty.repository.category;

import br.com.sunty.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByUrlCode(String urlCode);

    List<Category> findAllByActive(boolean active);

    List<Category> findAllByOrderByName();

    @Query(value = """
            select distinct c from Category c
            join c.subCategoryList sc join sc.courseList course
            where c.active = true and sc.active = true and course.visibility = 'PUBLICA'
            order by c.orderToShow
            """)
    List<Category> findActiveCategoriesWithActiveSubCategoriesAndPublicCourses();

    @Query(value = """
        SELECT DISTINCT c FROM Category c
        JOIN FETCH c.subCategoryList s
        JOIN s.courseList co
        WHERE c.active = true
        AND s.active = true
        AND co.visibility = 'PUBLICA'
        AND c.urlCode = :urlCode
        ORDER BY c.orderToShow, s.orderToShow
        """)
    Optional<Category> findCategoryActiveByUrlCode(String urlCode);
}
