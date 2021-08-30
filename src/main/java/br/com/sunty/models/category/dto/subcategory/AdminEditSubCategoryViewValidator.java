package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminEditSubCategoryViewValidator implements Validator {
    private final SubCategoryRepository subCategoryRepository;

    public AdminEditSubCategoryViewValidator(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AdminEditSubCategoryView.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminEditSubCategoryView adminEditSubCategoryView = (AdminEditSubCategoryView) target;
        if (subCategoryRepository.existsByUrlCode(adminEditSubCategoryView.getUrlCode())) {
            errors.rejectValue("urlCode", "category.url.duplicated");
        }
        if (subCategoryRepository.existsByName(adminEditSubCategoryView.getName())) {
            errors.rejectValue("name", "category.name.duplicated");
        }
    }
}
