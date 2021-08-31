package br.com.sunty.models.course.dto;

import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.repository.course.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminEditCourseFormValidatorTest {

    @Test
    void shouldFailWithDuplicatedName() {
        AdminEditCourseForm form = new AdminEditCourseForm(
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

        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByNameAndIdNot("Course", 1L)).thenReturn(true);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("name", "course.name.duplicated");
    }

    @Test
    void shouldPassWithDifferentName() {
        AdminEditCourseForm form = new AdminEditCourseForm(
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

        CourseRepository repository = mock(CourseRepository.class);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void shouldFailWithDuplicatedUrlCode() {
        AdminEditCourseForm form = new AdminEditCourseForm(
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

        CourseRepository repository = mock(CourseRepository.class);
        when(repository.existsByUrlCodeAndIdNot("course", 1L)).thenReturn(true);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("urlCode", "course.url.duplicated");
    }

    @Test
    void shouldPassWithDifferentUrlCode() {
        AdminEditCourseForm form = new AdminEditCourseForm(
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

        CourseRepository repository = mock(CourseRepository.class);

        AdminEditCourseFormValidator formValidator = new AdminEditCourseFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

}