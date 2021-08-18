package br.com.sunty.controller.login;

import br.com.sunty.models.category.Category;
import br.com.sunty.repository.category.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    private final CategoryRepository categoryRepository;

    LoginController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/login")
    String login(Model model) {
        List<Category> categories = categoryRepository.findAllActiveCategoriesWhereCategoryIsActiveAndCourseVisibilityIsTrueAndSubCategoryIsActive();

        model.addAttribute("categories", categories);
        return "login/login";
    }
}
