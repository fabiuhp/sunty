package br.com.sunty.controller.category;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.dto.category.ApiCategoryDto;
import br.com.sunty.repository.category.CategoryRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "apiListaCategorias")
    public ResponseEntity<List<ApiCategoryDto>> findAll() {
        List<Category> categories =  categoryRepository.findAllByIsActive(true);
        List<ApiCategoryDto> categoriesDto = categories.stream().map(ApiCategoryDto::new).toList();
        return ResponseEntity.ok(categoriesDto);
    }

    @GetMapping(value = "/api/bGltcGEtby1jYWNoZS1kYS1hcGktYWU")
    @CacheEvict(value = "apiListaCategorias", allEntries = true)
    public ResponseEntity<List<ApiCategoryDto>> limparCache() {
        List<Category> categories =  categoryRepository.findAllByIsActive(true);
        List<ApiCategoryDto> categoriesDto = categories.stream().map(ApiCategoryDto::new).toList();
        return ResponseEntity.ok(categoriesDto);
    }
}
