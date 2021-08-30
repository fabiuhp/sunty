package br.com.sunty.repository.subcategory;

import br.com.sunty.models.category.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> findByUrlCode(String urlCode);
    List<SubCategory> findAllByCategoryUrlCode(String categoryUrlCode);

    boolean existsByUrlCodeAndIdNot(String urlCode, Long id);
    boolean existsByUrlCode(String urlCode);
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
