package br.com.sunty.controller;

import br.com.sunty.models.category.Category;
import br.com.sunty.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/categories", produces = {"application/json", "application/xml"})
public class CategoryAdminController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String findAll(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "category/categoriesList";
    }

    @PostMapping
    public String create(@Valid Category category, BindingResult result) {
        if (result.hasErrors()){
            return "category/newCategoryForm";
        }
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/newCategoryForm";
    }

    @GetMapping("/{urlCode}")
    public String editar(@PathVariable String urlCode, Model model) {
        Category category = categoryRepository.findByUrlCode(urlCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, urlCode));
        model.addAttribute("category", category);
        return "category/editCategoryForm";
    }

    @PostMapping("/{urlCode}")
    public String update(Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }
}
