package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.SubCategory;
import br.com.sunty.repository.category.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AdminNewSubCategoryForm {

    @NotBlank(message = "{subcategory.name.not.null}")
    @Size(max = 255, message = "{subcategory.name.size.max}")
    private final String name;
    @NotBlank(message = "{subcategory.url.not.null}")
    @Size(max = 255, message = "{subcategory.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{subcategory.url.regex}")
    private final String urlCode;
    private final Boolean active;
    @Positive
    private final Integer orderToShow;
    @Size(max = 255, message = "{subcategory.guideText.size.max}")
    private final String guideText;
    private final String shortDescription;
    private final Long categoryId;

    public AdminNewSubCategoryForm(String name, String urlCode, Boolean active, Integer orderToShow, String guideText, String pathImg, String hexHtmlColor, String shortDescription, Long categoryId) {
        this.name = name;
        this.urlCode = urlCode;
        this.active = active;
        this.orderToShow = orderToShow;
        this.guideText = guideText;
        this.shortDescription = shortDescription;
        this.categoryId = categoryId;
    }

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

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Boolean getActive() {
        return active;
    }

    public Integer getOrderToShow() {
        return orderToShow;
    }

    public String getGuideText() {
        return guideText;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
