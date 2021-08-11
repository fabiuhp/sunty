package br.com.sunty.repository.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllBySubCategory(SubCategory subCategory, Pageable pageable);
}
