package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AdminEditCategoryForm {
    private final Long id;
    @NotBlank(message = "{category.name.not.null}")
    @Size(max = 255, message = "{category.name.size.max}")
    private final String name;
    @NotBlank(message = "{category.url.not.null}")
    @Size(max = 255, message = "{category.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{category.url.regex}")
    private final String urlCode;
    private final boolean active;
    @Positive
    private final Integer orderToShow;
    private final String guideText;
    @Size(max = 255, message = "{category.pathImg.size.max}")
    private final String pathImg;
    @Size(max = 7, message = "{category.hexHtmlColor.size.max}")
    @Pattern(regexp = "#(([0-9a-fA-F]{2}){3}|([0-9a-fA-F]){3})$", message = "{category.hexHtmlColor.regex}")
    private final String hexHtmlColor;
    private final String shortDescription;

    public AdminEditCategoryForm(Long id, String name, String urlCode, boolean active, Integer orderToShow, String guideText, String pathImg, String hexHtmlColor, String shortDescription) {
        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.active = active;
        this.orderToShow = orderToShow;
        this.guideText = guideText;
        this.pathImg = pathImg;
        this.hexHtmlColor = hexHtmlColor;
        this.shortDescription = shortDescription;
    }

    public Category toModel() {
        return new Category(
                this.getId(),
                this.getName(),
                this.getUrlCode(),
                this.getShortDescription(),
                this.getGuideText(),
                this.isActive(),
                this.getOrderToShow(),
                this.getPathImg(),
                this.getHexHtmlColor()
                );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Integer getOrderToShow() {
        return orderToShow;
    }

    public boolean isActive() {
        return active;
    }

    public String getGuideText() {
        return guideText;
    }

    public String getPathImg() {
        return pathImg;
    }

    public String getHexHtmlColor() {
        return hexHtmlColor;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
