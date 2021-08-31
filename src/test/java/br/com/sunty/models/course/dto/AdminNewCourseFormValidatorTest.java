package br.com.sunty.models.course.dto;

import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.repository.course.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminNewCourseFormValidatorTest {

    @Test
    void shouldFailWithDuplicatedName() {
        AdminNewCourseForm form = new AdminNewCourseForm(
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

        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByName("Course")).thenReturn(true);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("name", "course.name.duplicated");
    }

    @Test
    void shouldPassWithDifferentName() {
        AdminNewCourseForm form = new AdminNewCourseForm(
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


        CourseRepository repository = mock(CourseRepository.class);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void shouldFailWithDuplicatedUrlCode() {
        AdminNewCourseForm form = new AdminNewCourseForm(
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


        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByUrlCode("course")).thenReturn(true);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("urlCode", "course.url.duplicated");
    }

    @Test
    void shouldPassWithDifferentUrlCode() {
        AdminNewCourseForm form = new AdminNewCourseForm(
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

        CourseRepository repository = mock(CourseRepository.class);

        AdminNewCourseFormValidator formValidator = new AdminNewCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }
}