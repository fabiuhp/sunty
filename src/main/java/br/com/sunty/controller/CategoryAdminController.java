package br.com.sunty.controller;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryForm;
import br.com.sunty.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public String create(Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("category", new Category());
        return "category/newCategoryForm";
    }

    @PostMapping("/inactivate")
    public String inactivate(Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/{urlCode}")
    public String update(@PathVariable String urlCode, Model model){
        Optional<Category> category = categoryRepository.findByUrlCode(urlCode);
        if (category.isPresent()) {
            model.addAttribute("category", new Category());
            return "category/newCategoryForm";
        }
        return "redirect:/admin/categories";
    }
}
