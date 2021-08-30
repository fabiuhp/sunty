package br.com.sunty.models.category.dto.category;

import br.com.sunty.repository.category.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AdminNewCategoryFormValidator implements Validator {

    private final CategoryRepository categoryRepository;

    public AdminNewCategoryFormValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AdminNewCategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminNewCategoryForm adminNewCategoryForm = (AdminNewCategoryForm) target;
        if (categoryRepository.existsByUrlCode(adminNewCategoryForm.getUrlCode())){
            errors.rejectValue("urlCode", "category.url.duplicated");
        }
        if (categoryRepository.existsByName(adminNewCategoryForm.getName())) {
            errors.rejectValue("name", "category.name.duplicated");
        }
    }
}
