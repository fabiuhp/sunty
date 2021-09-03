package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminNewSubCategoryFormValidatorTest {

    @Test
    void validate__should_fail_with_duplicated_name() {
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
    void validate__should_pass_with_different_name() {
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
    void validate__should_fail_with_duplicated_urlCode() {
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
    void validate__should_pass_with_different_urlCode() {
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