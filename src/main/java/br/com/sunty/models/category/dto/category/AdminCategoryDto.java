package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;

public class AdminCategoryDto {
    private final String name;
    private final String urlCode;
    private final Integer orderToShow;
    private final boolean active;

    public AdminCategoryDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.orderToShow = category.getOrderToShow();
        this.active = category.getActive();
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
}
