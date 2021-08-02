package br.com.sunty.controller;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.CategoryDto;
import br.com.sunty.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/categories", produces = { "application/json", "application/xml" })
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> categories =  categoryRepository.findAll();
        List<CategoryDto> categoriesDto = categories.stream().map(CategoryDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(categoriesDto);
    }
}
