package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminNewSubCategoryFormValidator implements Validator {

    private final SubCategoryRepository subCategoryRepository;

    public AdminNewSubCategoryFormValidator(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AdminNewSubCategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminNewSubCategoryForm adminNewSubCategoryForm = (AdminNewSubCategoryForm) target;
        if (subCategoryRepository.existsByUrlCode(adminNewSubCategoryForm.getUrlCode())){
            errors.rejectValue("urlCode", "subcategory.url.duplicated");
        }
        if (subCategoryRepository.existsByName(adminNewSubCategoryForm.getName())) {
            errors.rejectValue("name", "subcategory.name.duplicated");
        }
    }
}
