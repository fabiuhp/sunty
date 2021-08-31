package br.com.sunty.models.course.dto;

import br.com.sunty.repository.course.CourseRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminEditCourseFormValidator implements Validator {
    private final CourseRepository courseRepository;

    public AdminEditCourseFormValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AdminEditCourseForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminEditCourseForm adminEditCourseForm = (AdminEditCourseForm) target;
        if (courseRepository.existsByUrlCodeAndIdNot(adminEditCourseForm.getUrlCode(), adminEditCourseForm.getId())) {
            errors.rejectValue("urlCode", "course.url.duplicated");
        }
        if (courseRepository.existsByNameAndIdNot(adminEditCourseForm.getName(), adminEditCourseForm.getId())) {
            errors.rejectValue("name", "course.name.duplicated");
        }
    }
}
