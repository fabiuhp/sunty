package br.com.sunty.models.category.dto.category;

import br.com.sunty.repository.category.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminEditCategoryFormValidator implements Validator {
    private final CategoryRepository categoryRepository;

    public AdminEditCategoryFormValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AdminEditCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminEditCategoryForm adminEditCategoryForm = (AdminEditCategoryForm) target;
        if (categoryRepository.existsByUrlCodeAndIdNot(adminEditCategoryForm.getUrlCode(), adminEditCategoryForm.getId())) {
            errors.rejectValue("urlCode", "category.url.duplicated");
        }
        if (categoryRepository.existsByNameAndIdNot(adminEditCategoryForm.getName(), adminEditCategoryForm.getId())) {
            errors.rejectValue("name", "category.name.duplicated");
        }
    }
}
