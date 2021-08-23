package br.com.sunty.repository.subcategory;

import br.com.sunty.models.category.SubCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SubCategoryRepositoryTest {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Test
    void shouldFindByUrlCode() {
        String subCategoryName = "builds-e-controle-de-versao";
        SubCategory subCategory = subCategoryRepository.findByUrlCode(subCategoryName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        assertThat(subCategory.getUrlCode())
                .isEqualTo(subCategoryName);
    }

    @Test
    void shouldFindAllByCategoryUrlCode() {
        List<SubCategory> subCategories = subCategoryRepository.findAllByCategoryUrlCode("devops");

        assertThat(subCategories)
                .hasSize(1)
                .extracting(SubCategory::getUrlCode)
                .containsExactly("builds-e-controle-de-versao");
    }

}