package br.com.sunty.repository.category;

import br.com.sunty.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByUrlCode(String urlCode);
}
