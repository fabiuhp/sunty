package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Value
public class AdminNewCategoryForm {
    @NotBlank(message = "{category.name.not.null}")
    @Size(max = 255, message = "{category.name.size.max}")
    String name;

    @NotBlank(message = "{category.url.not.null}")
    @Size(max = 255, message = "{category.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{category.url.regex}")
    String urlCode;

    Boolean active;

    @Positive
    Integer orderToShow;

    @Size(max = 255, message = "{category.guideText.size.max}")
    String guideText;

    @Size(max = 255, message = "{category.pathImg.size.max}")
    String pathImg;

    @Size(max = 7, message = "{category.hexHtmlColor.size.max}")
    @Pattern(regexp = "#(([0-9a-fA-F]{2}){3}|([0-9a-fA-F]){3})$", message = "{category.hexHtmlColor.regex}")
    String hexHtmlColor;

    String shortDescription;

    public Category toModel() {
        return new Category(
                this.getName(),
                this.getUrlCode(),
                this.getShortDescription(),
                this.getGuideText(),
                this.getActive(),
                this.getOrderToShow(),
                this.getPathImg(),
                this.getHexHtmlColor()
                );
    }
}
