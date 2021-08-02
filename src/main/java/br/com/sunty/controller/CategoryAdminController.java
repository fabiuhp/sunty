package br.com.sunty.controller;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryForm;
import br.com.sunty.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/categories", produces = { "application/json", "application/xml" })
public class CategoryAdminController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String findAll(Model model) {
        List<Category> categories =  categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "category/categoriesList";
    }

    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("category", new Category());
        return "category/newCategoryForm";
    }

    @PostMapping("/new")
    public String create(Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }
}
