package br.com.sunty.repository.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> findByUrlCode(String urlCode);
    Optional<SubCategory> findAllByCategoryOrderByOrderToShowAsc(Category category);
    List<SubCategory> findAllByCategoryUrlCode(String categoryUrlCode);
}
