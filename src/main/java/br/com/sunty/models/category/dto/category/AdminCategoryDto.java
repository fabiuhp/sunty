package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AdminCategoryDto {
    @NotBlank(message = "{category.name.not.null}")
    @Size(max = 255, message = "{category.name.size.max}")
    private final String name;
    @NotBlank(message = "{category.url.not.null}")
    @Size(max = 255, message = "{category.url.size.max}")
    @Pattern(regexp = "[a-z]+([a-z-]*)[a-z]", message = "{category.url.regex}")
    private final String urlCode;
    @Positive
    private final Integer orderToShow;
    private final boolean isActive;

    public AdminCategoryDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.orderToShow = category.getOrderToShow();
        this.isActive = category.getActive();
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
        return isActive;
    }
}
