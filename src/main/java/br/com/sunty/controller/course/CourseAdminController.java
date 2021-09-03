package br.com.sunty.controller.course;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.category.dto.subcategory.AdminSubCategoryDto;
import br.com.sunty.models.course.AdminCourseDto;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.dto.AdminEditCourseForm;
import br.com.sunty.models.course.dto.AdminEditCourseFormValidator;
import br.com.sunty.models.course.dto.AdminNewCourseForm;
import br.com.sunty.models.course.dto.AdminNewCourseFormValidator;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.instructor.InstructorRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@AllArgsConstructor
public class CourseAdminController {
    private final CourseRepository courseRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final InstructorRepository instructorRepository;
    private final AdminNewCourseFormValidator adminNewCourseFormValidator;
    private final AdminEditCourseFormValidator adminEditCourseFormValidator;

    @InitBinder("adminNewCourseForm")
    void initBinderNew(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(adminNewCourseFormValidator);
    }

    @InitBinder("adminEditCourseForm")
    void initBinderEdit(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(adminEditCourseFormValidator);
    }

    @GetMapping("/admin/courses/{categoryUrlCode}/{subcategoryUrlCode}")
    public String findAll(@PathVariable String subcategoryUrlCode,
                          @PathVariable String categoryUrlCode,
                          @PageableDefault(size = 5)
                          Pageable pageable,
                          Model model) {

        AdminSubCategoryDto adminSubCategoryDto = subCategoryRepository.findByUrlCode(subcategoryUrlCode)
                .map(AdminSubCategoryDto::new)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, subcategoryUrlCode));

        Page<Course> courses = courseRepository.findAllBySubCategory_UrlCode(subcategoryUrlCode, pageable);
        Page<AdminCourseDto> courseDtos = courses.map(AdminCourseDto::new);

        model.addAttribute("subCategory", adminSubCategoryDto);
        model.addAttribute("courses", courseDtos);
        return "course/courseList";
    }

    @GetMapping("/admin/courses/new")
    public String createForm(Model model) {
        List<Instructor> instructors = instructorRepository.findAll();
        List<SubCategory> subCategories = subCategoryRepository.findAll();

        model.addAttribute("subCategories", subCategories);
        model.addAttribute("instructors", instructors);
        return "course/newCourseForm";
    }

    @PostMapping("/admin/courses")
    public String create(@Valid AdminNewCourseForm adminNewCourseForm, BindingResult result, Model model) {
        if (result.hasErrors()){
            return createForm(model);
        }

        Instructor instructor = instructorRepository.findById(adminNewCourseForm.getInstructorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        SubCategory subCategory = subCategoryRepository.findById(adminNewCourseForm.getSubCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Course course = adminNewCourseForm.toModel(instructor, subCategory);
        courseRepository.save(course);
        return String.format("redirect:/admin/courses/%s/%s", course.getCategoryUrlCode(), course.getSubCategoryUrlCode());
    }

    @GetMapping("/admin/courses/{categoryUrlCode}/{subcategoryUrlCode}/{courseCode}")
    public String edit(@PathVariable String categoryUrlCode,
                       @PathVariable String subcategoryUrlCode,
                       @PathVariable String courseCode,
                       Model model) {
        Course course = courseRepository.findByUrlCode(courseCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, courseCode));
        List<Instructor> instructors = instructorRepository.findAll();
        Instructor instructor = instructorRepository.findById(course.getInstructorId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        SubCategory subCategory = subCategoryRepository.findById(course.getSubCategoryId())
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND));

        model.addAttribute("adminEditCourseForm", new AdminEditCourseForm(course));
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("instructors", instructors);
        model.addAttribute("subcategory", subcategoryUrlCode);
        model.addAttribute("category", categoryUrlCode);
        return "course/editCourseForm";
    }

    @PostMapping("/admin/courses/{category}/{subcategory}/{course}")
    public String update(@PathVariable("category") String categoryUrlCode,
                         @PathVariable("subcategory") String subcategoryUrlCode,
                         @PathVariable("course") String courseUrlCode,
                         @Valid AdminEditCourseForm adminEditCourseForm,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()){
            return "course/editCourseForm";
        }
        Instructor instructor = instructorRepository.findById(adminEditCourseForm.getInstructorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        SubCategory subCategory = subCategoryRepository.findById(adminEditCourseForm.getSubCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Course course = adminEditCourseForm.toModel(instructor, subCategory);

        courseRepository.save(course);
        return "redirect:/admin/courses/" + categoryUrlCode + "/" + subcategoryUrlCode;
    }
}
