package br.com.sunty.repository.course;

import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = """
            select category.name, count(c.id) as coursesquantity
            from category
            left join sub_category sc on category.id = sc.category_id
            left join course c on sc.id = c.subcategory_id
            group by category.name;
            """, nativeQuery = true)
    List<CourseProjection> categoriesWithNumberOfCourses();
    Optional<Course> findByUrlCode(String urlCode);
    Page<Course> findAllBySubCategory_UrlCode(String subCategoryUrlCode, Pageable pageable);
}
