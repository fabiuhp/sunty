package br.com.sunty.repository.category;

import br.com.sunty.models.category.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void shouldFindByUrlCode() {
        String categoryName = "devops";
        Category category = categoryRepository.findByUrlCode(categoryName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        assertThat(category.getName())
                .isEqualTo(categoryName);
    }

    @Test
    void shouldFindAllByActive() {
        List<Category> categories = categoryRepository.findAllByActive(true);

        assertThat(categories)
                .hasSize(2)
                .extracting(Category::getUrlCode)
                .containsExactly("programacao", "devops");
    }

    @Test
    void shouldFindAllByOrderByName() {
        List<Category> categories = categoryRepository.findAllByOrderByName();

        assertThat(categories)
                .hasSize(3)
                .extracting(Category::getUrlCode)
                .containsSequence("business", "devops", "programacao");
    }

    @Test
    void shouldFindActiveCategoriesWithActiveSubCategoriesAndPublicCourses() {
        List<Category> categories = categoryRepository.findActiveCategoriesWithActiveSubCategoriesAndPublicCourses();

        assertThat(categories)
                .hasSize(2)
                .extracting(Category::getUrlCode)
                .contains("devops", "programacao");
    }

    @Test
    void shouldFindCategoryActiveByUrlCode() {
        String activeCategory = "programacao";
        Category category = categoryRepository.findCategoryActiveByUrlCode(activeCategory)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        assertThat(category).isNotNull();
    }

    @Test
    void shouldNotFindCategoryActiveByUrlCode() {
        String inactiveCategory = "business";

        assertThatThrownBy(() -> categoryRepository.findCategoryActiveByUrlCode(inactiveCategory)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}