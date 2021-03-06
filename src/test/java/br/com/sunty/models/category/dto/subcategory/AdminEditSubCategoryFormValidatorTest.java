package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AdminEditSubCategoryFormValidatorTest {


    private AdminEditSubCategoryForm getAdminEditSubCategoryForm() {
        return new AdminEditSubCategoryForm(
                1L,
                "SubCategoria",
                "sub-categoria",
                true,
                1,
                "Texto Guia",
                "Texto guia",
                1L,
                "Categoria"
        );
    }

    @Test
    void validate__should_fail_with_duplicated_name() {
        AdminEditSubCategoryForm form = getAdminEditSubCategoryForm();

        SubCategoryRepository repository = mock(SubCategoryRepository.class);
        when(repository.existsByNameAndIdNot("SubCategoria", 1L)).thenReturn(true);

        AdminEditSubCategoryFormValidator formValidator = new AdminEditSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("name", "subcategory.name.duplicated");
    }

    @Test
    void validate__should_pass_with_different_name() {
        AdminEditSubCategoryForm form = mock(AdminEditSubCategoryForm.class);

        SubCategoryRepository repository = mock(SubCategoryRepository.class);

        AdminEditSubCategoryFormValidator formValidator = new AdminEditSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void validate__should_fail_with_duplicated_urlCode() {
        AdminEditSubCategoryForm form = getAdminEditSubCategoryForm();

        SubCategoryRepository repository = mock(SubCategoryRepository.class);
        when(repository.existsByUrlCodeAndIdNot("sub-categoria", 1L)).thenReturn(true);

        AdminEditSubCategoryFormValidator formValidator = new AdminEditSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors).rejectValue("urlCode", "subcategory.url.duplicated");
    }

    @Test
    void validate__should_pass_with_different_urlCode() {
        AdminEditSubCategoryForm form = mock(AdminEditSubCategoryForm.class);

        SubCategoryRepository repository = mock(SubCategoryRepository.class);

        AdminEditSubCategoryFormValidator formValidator = new AdminEditSubCategoryFormValidator(repository);
        Errors errors = mock(Errors.class);

        formValidator.validate(form, errors);
        verify(errors, never()).rejectValue(anyString(), anyString());
    }
}