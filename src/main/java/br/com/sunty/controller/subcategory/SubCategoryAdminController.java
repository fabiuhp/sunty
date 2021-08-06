package br.com.sunty.controller.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.repository.category.CategoryRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

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
        List<SubCategory> subCategoryList = category.getSubCategoryList();

        model.addAttribute("category", category);
        model.addAttribute("subCategoryList", subCategoryList);
        return "subcategory/subCategoriesList";
    }
}
