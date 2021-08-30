package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminEditSubCategoryFormValidator implements Validator {
    private final SubCategoryRepository subCategoryRepository;

    public AdminEditSubCategoryFormValidator(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AdminEditSubCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminEditSubCategoryForm adminEditSubCategoryForm = (AdminEditSubCategoryForm) target;
        if (subCategoryRepository.existsByUrlCodeAndIdNot(adminEditSubCategoryForm.getUrlCode(), adminEditSubCategoryForm.getId())) {
            errors.rejectValue("urlCode", "category.url.duplicated");
        }
        if (subCategoryRepository.existsByNameAndIdNot(adminEditSubCategoryForm.getName(), adminEditSubCategoryForm.getId())) {
            errors.rejectValue("name", "category.name.duplicated");
        }
    }
}
