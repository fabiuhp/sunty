package br.com.sunty.controller.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class CourseAdminController {
    private final CourseRepository courseRepository;
    private final SubCategoryRepository subCategoryRepository;

    public CourseAdminController(CourseRepository courseRepository, SubCategoryRepository subCategoryRepository) {
        this.courseRepository = courseRepository;
        this.subCategoryRepository = subCategoryRepository;
    }


    @GetMapping("/admin/courses/{categoryUrlCode}/{subcategoryUrlCode}")
    public String findAll(@PathVariable String categoryUrlCode,
                          @PathVariable String subcategoryUrlCode,
                          @PageableDefault(size = 5)
                          Pageable pageable,
                          Model model) {

        SubCategory subCategory = subCategoryRepository.findByUrlCode(subcategoryUrlCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, subcategoryUrlCode));

        Page<Course> courses = courseRepository.findAllBySubCategory(subCategory, pageable);

        model.addAttribute("subCategory", subCategory);
        model.addAttribute("category", categoryUrlCode);
        model.addAttribute("courses", courses);
        return "course/courseList";
    }
}
