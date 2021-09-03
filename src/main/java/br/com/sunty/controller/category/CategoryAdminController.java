package br.com.sunty.controller.category;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.dto.category.*;
import br.com.sunty.repository.category.CategoryRepository;
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
public class CategoryAdminController {

    private final CategoryRepository categoryRepository;
    private final AdminNewCategoryFormValidator adminNewCategoryFormValidator;
    private final AdminEditCategoryFormValidator adminEditCategoryFormValidator;

    @InitBinder("adminNewCategoryForm")
    void initBinderNew(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(adminNewCategoryFormValidator);
    }

    @InitBinder("adminEditCategoryForm")
    void initBinderEdit(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(adminEditCategoryFormValidator);
    }

    @GetMapping("/{categoryCode:[a-z-]+}")
    public String publicPageCategories(@PathVariable String categoryCode, Model model) {
        ApiCategoryDetailsDto apiCategoryDetailsDto = categoryRepository.findCategoryActiveByUrlCode(categoryCode)
                .map(ApiCategoryDetailsDto::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, categoryCode));

        model.addAttribute("category", apiCategoryDetailsDto);
        return "api/category/category";
    }

    @GetMapping("/")
    public String homePage() {
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories")
    public String findAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<AdminCategoryDto> adminCategoryDto = categories.stream().map(AdminCategoryDto::new).toList();
        model.addAttribute("categories", adminCategoryDto);
        return "category/categoriesList";
    }

    @GetMapping("/admin/categories/new")
    public String createForm(AdminNewCategoryForm adminNewCategoryForm) {
        return "category/newCategoryForm";
    }

    @PostMapping("/admin/categories")
    public String create(@Valid AdminNewCategoryForm dto, BindingResult result) {
        if (result.hasErrors()) {
            return createForm(dto);
        }
        Category category = dto.toModel();
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/{urlCode}")
    public String edit(@PathVariable String urlCode, AdminEditCategoryForm adminEditCategoryForm,Model model) {
        Category category = categoryRepository.findByUrlCode(urlCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, urlCode));

        model.addAttribute("adminEditCategoryForm", new AdminEditCategoryForm(category));
        return "category/editCategoryForm";
    }

    @PostMapping("/admin/categories/{urlCode}")
    public String update(@PathVariable String urlCode, @Valid AdminEditCategoryForm adminEditCategoryForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category/editCategoryForm";
        }

        Category category = adminEditCategoryForm.toModel();
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }
}
