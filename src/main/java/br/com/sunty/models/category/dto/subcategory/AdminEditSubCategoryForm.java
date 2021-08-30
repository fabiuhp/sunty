package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.repository.category.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminEditSubCategoryForm {

    private Long id;
    @NotBlank(message = "{subcategory.name.not.null}")
    @Size(max = 255, message = "{subcategory.name.size.max}")
    private String name;
    @NotBlank(message = "{subcategory.url.not.null}")
    @Size(max = 255, message = "{subcategory.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{subcategory.url.regex}")
    private String urlCode;
    private Boolean active;
    @Positive
    private Integer orderToShow;
    @Size(max = 255, message = "{subcategory.guideText.size.max}")
    private String guideText;
    private String shortDescription;
    private Long categoryId;
    private String categoryName;

    public SubCategory toModel(CategoryRepository categoryRepository) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new SubCategory(
                this.getId(),
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
