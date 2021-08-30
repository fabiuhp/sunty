package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminEditCategoryForm {
    private Long id;

    @NotBlank(message = "{category.name.not.null}")
    @Size(max = 255, message = "{category.name.size.max}")
    private String name;

    @NotBlank(message = "{category.url.not.null}")
    @Size(max = 255, message = "{category.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{category.url.regex}")
    private String urlCode;

    private boolean active;

    @Positive
    private Integer orderToShow;

    private String guideText;

    @Size(max = 255, message = "{category.pathImg.size.max}")
    private String pathImg;

    @Size(max = 7, message = "{category.hexHtmlColor.size.max}")
    @Pattern(regexp = "#(([0-9a-fA-F]{2}){3}|([0-9a-fA-F]){3})$", message = "{category.hexHtmlColor.regex}")
    private String hexHtmlColor;

    private String shortDescription;

    public AdminEditCategoryForm(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.active = category.getActive();
        this.orderToShow = category.getOrderToShow();
        this.guideText = category.getGuideText();
        this.shortDescription = category.getShortDescription();
        this.hexHtmlColor = category.getHexHtmlColor();
        this.pathImg = category.getPathImg();
    }

    public Category toModel() {
        return new Category(
                this.id,
                this.name,
                this.urlCode,
                this.shortDescription,
                this.guideText,
                this.active,
                this.orderToShow,
                this.pathImg,
                this.hexHtmlColor
        );
    }
}
