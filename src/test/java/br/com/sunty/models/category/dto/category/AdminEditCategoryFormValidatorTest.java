package br.com.sunty.models.category.dto.category;

import br.com.sunty.repository.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminEditCategoryFormValidatorTest {

    @Test
    void shouldFailWithDuplicatedName() {
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
    void shouldPassWithDifferentName() {
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
    void shouldFailWithDuplicatedUrlCode() {
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
    void shouldPassWithDifferentUrlCode() {
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