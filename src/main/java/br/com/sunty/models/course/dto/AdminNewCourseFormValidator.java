package br.com.sunty.models.course.dto;

import br.com.sunty.models.category.dto.category.AdminNewCategoryForm;
import br.com.sunty.repository.course.CourseRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminNewCourseFormValidator implements Validator {

    private final CourseRepository courseRepository;

    public AdminNewCourseFormValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AdminNewCategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminNewCategoryForm adminNewCategoryForm = (AdminNewCategoryForm) target;
        if (courseRepository.existsByUrlCode(adminNewCategoryForm.getUrlCode())){
            errors.rejectValue("urlCode", "category.url.duplicated");
        }
        if (courseRepository.existsByName(adminNewCategoryForm.getName())) {
            errors.rejectValue("name", "category.name.duplicated");
        }
    }
}
