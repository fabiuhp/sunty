package br.com.sunty.controller.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.category.dto.AdminCategoryDto;
import br.com.sunty.models.category.dto.AdminEditSubCategoryForm;
import br.com.sunty.models.category.dto.AdminNewSubCategoryForm;
import br.com.sunty.models.category.dto.AdminSubCategoryDto;
import br.com.sunty.repository.category.CategoryRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SubCategoryAdminController {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubCategoryAdminController(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/admin/subcategories/{urlCode}")
    public String findAll(@PathVariable String urlCode, Model model) {
        Category category = categoryRepository.findByUrlCode(urlCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, urlCode));
        AdminCategoryDto adminSubCategoryDto = new AdminCategoryDto(category);

        List<SubCategory> subCategoryList = category.getSubCategoryList();
        List<AdminSubCategoryDto> subCategoryDtoList = subCategoryList.stream().map(AdminSubCategoryDto::new).toList();

        model.addAttribute("category", adminSubCategoryDto);
        model.addAttribute("subCategoryList", subCategoryDtoList);
        return "subcategory/subCategoriesList";
    }

    @GetMapping("/admin/subcategories/{categoryCode}/{subcategoryCode}")
    public String edit(@PathVariable String categoryCode, @PathVariable String subcategoryCode, Model model) {
        SubCategory subCategory = subCategoryRepository.findByUrlCode(subcategoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, subcategoryCode));

        model.addAttribute("subCategory", subCategory);
        return "subcategory/editSubCategoryForm";
    }

    @PostMapping("/admin/subcategories/{categoryCode}/{subcategoryCode}")
    public String update(@Valid AdminEditSubCategoryForm adminEditSubCategoryForm, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "subcategory/editSubCategoryForm";
        }
        SubCategory subCategory = adminEditSubCategoryForm.toModel(categoryRepository);
        subCategoryRepository.save(subCategory);
        return "redirect:/admin/subcategories/" + subCategory.getCategory().getUrlCode();
    }

    @GetMapping("/admin/subcategories/new")
    public String createForm(Model model) {
        List<Category> categories = categoryRepository.findAllByOrderByName();
        model.addAttribute("categories", categories);
        return "subcategory/newSubCategoryForm";
    }

    @PostMapping("/admin/subcategories")
    public String create(@Valid AdminNewSubCategoryForm adminNewSubCategoryForm, BindingResult result, Model model) {
        if (result.hasErrors()){
            return createForm(model);
        }
        SubCategory subCategory = adminNewSubCategoryForm.toModel(categoryRepository);
        subCategoryRepository.save(subCategory);
        return "redirect:/admin/subcategories/" + subCategory.getCategory().getUrlCode();
    }
}
