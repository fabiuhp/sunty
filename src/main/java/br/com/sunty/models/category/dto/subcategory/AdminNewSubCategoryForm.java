package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.repository.category.CategoryRepository;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Value
public class AdminNewSubCategoryForm {

    @NotBlank(message = "{subcategory.name.not.null}")
    @Size(max = 255, message = "{subcategory.name.size.max}")
    String name;
    @NotBlank(message = "{subcategory.url.not.null}")
    @Size(max = 255, message = "{subcategory.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{subcategory.url.regex}")
    String urlCode;
    Boolean active;
    @Positive
    Integer orderToShow;
    @Size(max = 255, message = "{subcategory.guideText.size.max}")
    String guideText;
    String shortDescription;
    Long categoryId;

    public SubCategory toModel(CategoryRepository categoryRepository) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new SubCategory(
                this.getName(),
                this.getUrlCode(),
                this.getShortDescription(),
                this.getActive(),
                this.getOrderToShow(),
                this.getGuideText(),
                category
                );
    }
}
