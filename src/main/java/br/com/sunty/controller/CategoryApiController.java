package br.com.sunty.controller;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryDto;
import br.com.sunty.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    public CategoryApiController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(value = "/api/categories", produces = { "application/json", "application/xml" })
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> categories =  categoryRepository.findAll();
        List<CategoryDto> categoriesDto = categories.stream().map(CategoryDto::new).toList();
        return ResponseEntity.ok(categoriesDto);
    }
}
