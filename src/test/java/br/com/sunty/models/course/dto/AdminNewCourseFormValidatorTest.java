package br.com.sunty.models.course.dto;

import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.repository.course.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminNewCourseFormValidatorTest {

    private AdminNewCourseForm getAdminNewCourseForm() {
        return new AdminNewCourseForm(
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
        AdminNewCourseForm form = getAdminNewCourseForm();

        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByName("Course")).thenReturn(true);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("name", "course.name.duplicated");
    }

    @Test
    void validate__should_pass_with_different_name() {
        AdminNewCourseForm form = getAdminNewCourseForm();

        CourseRepository repository = mock(CourseRepository.class);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void validate__should_fail_with_duplicated_urlCode() {
        AdminNewCourseForm form = getAdminNewCourseForm();

        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByUrlCode("course")).thenReturn(true);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("urlCode", "course.url.duplicated");
    }

    @Test
    void validate__should_pass_with_different_urlCode() {
        AdminNewCourseForm form = getAdminNewCourseForm();

        CourseRepository repository = mock(CourseRepository.class);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }
}