package br.com.sunty.controller.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.category.dto.category.AdminCategoryDto;
import br.com.sunty.models.category.dto.subcategory.*;
import br.com.sunty.repository.category.CategoryRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class SubCategoryAdminController {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final AdminNewSubCategoryFormValidator adminNewSubCategoryFormValidator;
    private final AdminEditSubCategoryFormValidator adminEditSubCategoryFormValidator;

    @InitBinder("adminNewSubCategoryForm")
    void initBinderNew(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(adminNewSubCategoryFormValidator);
    }

    @InitBinder("adminEditSubCategoryForm")
    void initBinderEdit(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(adminEditSubCategoryFormValidator);
    }

    @GetMapping("/admin/subcategories/{categoryUrlCode}")
    public String findAll(@PathVariable String categoryUrlCode, Model model) {
        AdminCategoryDto adminSubCategoryDto = categoryRepository.findByUrlCode(categoryUrlCode)
                .map(AdminCategoryDto::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, categoryUrlCode));

        List<AdminSubCategoryDto> subCategoryDtoList = subCategoryRepository.findAllByCategoryUrlCode(categoryUrlCode)
                .stream().map(AdminSubCategoryDto::new).toList();

        model.addAttribute("category", adminSubCategoryDto);
        model.addAttribute("subCategoryList", subCategoryDtoList);
        return "subcategory/subCategoriesList";
    }

    @GetMapping("/admin/subcategories/{categoryCode}/{subcategoryCode}")
    public String edit(@PathVariable String categoryCode,
                       @PathVariable String subcategoryCode,
                       AdminEditSubCategoryForm adminEditSubCategoryForm,
                       Model model) {
        SubCategory subCategory = subCategoryRepository.findByUrlCode(subcategoryCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, subcategoryCode));

        model.addAttribute("adminEditSubCategoryForm", new AdminEditSubCategoryForm(subCategory));
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
    public String createForm(AdminNewSubCategoryForm adminNewSubCategoryForm, Model model) {
        List<Category> categories = categoryRepository.findAllByOrderByName();
        model.addAttribute("categories", categories);
        return "subcategory/newSubCategoryForm";
    }

    @PostMapping("/admin/subcategories")
    public String create(@Valid AdminNewSubCategoryForm adminNewSubCategoryForm, BindingResult result, Model model) {
        if (result.hasErrors()){
            return createForm(adminNewSubCategoryForm, model);
        }
        SubCategory subCategory = adminNewSubCategoryForm.toModel(categoryRepository);
        subCategoryRepository.save(subCategory);
        return "redirect:/admin/subcategories/" + subCategory.getCategory().getUrlCode();
    }
}
