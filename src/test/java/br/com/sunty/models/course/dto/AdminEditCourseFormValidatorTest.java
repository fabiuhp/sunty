package br.com.sunty.models.course.dto;

import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.repository.course.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminEditCourseFormValidatorTest {

    private AdminEditCourseForm getAdminEditCourseForm() {
        return new AdminEditCourseForm(
                1L,
                "Course",
                "course",
                2,
                CourseVisibility.PUBLICA,
                "Publico alvo",
                1L,
                "Roteiro",
                "Skills desenvolvidas",
                1L
        );
    }

    @Test
    void validate__should_fail_with_duplicated_name() {
        AdminEditCourseForm form = getAdminEditCourseForm();

        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByNameAndIdNot("Course", 1L)).thenReturn(true);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("name", "course.name.duplicated");
    }

    @Test
    void validate__should_pass_with_different_name() {
        AdminEditCourseForm form = mock(AdminEditCourseForm.class);

        CourseRepository repository = mock(CourseRepository.class);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void validate__should_fail_with_duplicated_urlCode() {
        AdminEditCourseForm form = getAdminEditCourseForm();

        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByUrlCodeAndIdNot("course", 1L)).thenReturn(true);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("urlCode", "course.url.duplicated");
    }

    @Test
    void validate__should_pass_with_different_urlCode() {
        AdminEditCourseForm form = mock(AdminEditCourseForm.class);

        CourseRepository repository = mock(CourseRepository.class);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

}