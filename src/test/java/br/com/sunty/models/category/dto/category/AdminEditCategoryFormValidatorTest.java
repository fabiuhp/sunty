package br.com.sunty.models.category.dto.category;

import br.com.sunty.repository.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminEditCategoryFormValidatorTest {

    @Test
    void validate__should_fail_with_duplicated_name() {
        AdminEditCategoryForm form = new AdminEditCategoryForm(
                1L,
                "Categoria",
                "categoria",
                true,
                1,
                "Texto guia",
                "C:",
                "#123456",
                "descricao curta"
        );

        CategoryRepository repository = mock(CategoryRepository.class);
        when(repository.existsByNameAndIdNot("Categoria", 1L)).thenReturn(true);

        AdminEditCategoryFormValidator validator = new AdminEditCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        validator.validate(form, errors);
        verify(errors).rejectValue("name", "category.name.duplicated");
    }

    @Test
    void validate__should_pass_with_different_name() {
        AdminEditCategoryForm form = new AdminEditCategoryForm(
                1L,
                "Categoria",
                "categoria",
                true,
                1,
                "Texto guia",
                "C:",
                "#123456",
                "descricao curta"
        );

        CategoryRepository repository = mock(CategoryRepository.class);

        AdminEditCategoryFormValidator validator = new AdminEditCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        validator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void validate__should_fail_with_duplicated_urlCode() {
        AdminEditCategoryForm form = new AdminEditCategoryForm(
                1L,
                "Categoria",
                "categoria",
                true,
                1,
                "Texto guia",
                "C:",
                "#123456",
                "descricao curta"
        );

        CategoryRepository repository = mock(CategoryRepository.class);
        when(repository.existsByUrlCodeAndIdNot("categoria", 1L)).thenReturn(true);

        AdminEditCategoryFormValidator validator = new AdminEditCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        validator.validate(form, errors);
        verify(errors).rejectValue("urlCode", "category.url.duplicated");
    }

    @Test
    void validate__should_pass_with_different_urlCode() {
        AdminEditCategoryForm form = new AdminEditCategoryForm(
                1L,
                "Categoria",
                "categoria",
                true,
                1,
                "Texto guia",
                "C:",
                "#123456",
                "descricao curta"
        );

        CategoryRepository repository = mock(CategoryRepository.class);

        AdminEditCategoryFormValidator validator = new AdminEditCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        validator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

}