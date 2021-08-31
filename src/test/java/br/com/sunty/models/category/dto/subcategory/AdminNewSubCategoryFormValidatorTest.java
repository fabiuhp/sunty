package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminNewSubCategoryFormValidatorTest {

    @Test
    void shouldFailWithDuplicatedName() {
        AdminNewSubCategoryForm form = new AdminNewSubCategoryForm(
                "SubCategoria",
                "sub-categoria",
                true,
                1,
                "Texto guia",
                "descricao curta",
                1L
        );

        SubCategoryRepository repository = mock(SubCategoryRepository.class);
        when(repository.existsByName("SubCategoria")).thenReturn(true);

        AdminNewSubCategoryFormValidator formValidator = new AdminNewSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("name", "subcategory.name.duplicated");
    }

    @Test
    void shouldPassWithDifferentName() {
        AdminNewSubCategoryForm form = new AdminNewSubCategoryForm(
                "SubCategoria",
                "sub-categoria",
                true,
                1,
                "Texto guia",
                "descricao curta",
                1L
        );

        SubCategoryRepository repository = mock(SubCategoryRepository.class);

        AdminNewSubCategoryFormValidator formValidator = new AdminNewSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void shouldFailWithDuplicatedUrlCode() {
        AdminNewSubCategoryForm form = new AdminNewSubCategoryForm(
                "SubCategoria",
                "sub-categoria",
                true,
                1,
                "Texto guia",
                "descricao curta",
                1L
        );

        SubCategoryRepository repository = mock(SubCategoryRepository.class);
        when(repository.existsByUrlCode("sub-categoria")).thenReturn(true);

        AdminNewSubCategoryFormValidator formValidator = new AdminNewSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("urlCode", "subcategory.url.duplicated");
    }

    @Test
    void shouldPassWithDifferentUrlCode() {
        AdminNewSubCategoryForm form = new AdminNewSubCategoryForm(
                "SubCategoria",
                "sub-categoria",
                true,
                1,
                "Texto guia",
                "descricao curta",
                1L
        );

        SubCategoryRepository repository = mock(SubCategoryRepository.class);

        AdminNewSubCategoryFormValidator formValidator = new AdminNewSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }
}