package br.com.sunty.models.category.dto.category;

import br.com.sunty.repository.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class AdminNewCategoryFormValidatorTest {

    @Test
    void shouldFailWithDuplicatedName() {
        AdminNewCategoryForm adminNewCategoryForm = new AdminNewCategoryForm(
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
        when(repository.existsByName("Categoria")).thenReturn(true);

        AdminNewCategoryFormValidator adminNewCategoryFormValidator = new AdminNewCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        adminNewCategoryFormValidator.validate(adminNewCategoryForm, errors);
        verify(errors).rejectValue("name", "category.name.duplicated");
    }

    @Test
    void shouldPassWithDifferentName() {
        AdminNewCategoryForm adminNewCategoryForm = new AdminNewCategoryForm(
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

        AdminNewCategoryFormValidator adminNewCategoryFormValidator = new AdminNewCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        adminNewCategoryFormValidator.validate(adminNewCategoryForm, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void shouldFailWithDuplicatedUrlCode() {
        AdminNewCategoryForm adminNewCategoryForm = new AdminNewCategoryForm(
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
        when(repository.existsByUrlCode("categoria")).thenReturn(true);

        AdminNewCategoryFormValidator adminNewCategoryFormValidator = new AdminNewCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        adminNewCategoryFormValidator.validate(adminNewCategoryForm, errors);
        verify(errors).rejectValue("urlCode", "category.url.duplicated");
    }

    @Test
    void shouldPassWithDifferentUrlCode() {
        AdminNewCategoryForm adminNewCategoryForm = new AdminNewCategoryForm(
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

        AdminNewCategoryFormValidator adminNewCategoryFormValidator = new AdminNewCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        adminNewCategoryFormValidator.validate(adminNewCategoryForm, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }
}