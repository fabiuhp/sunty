package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.SubCategory;

public class AdminSubCategoryDto {

    private final String name;
    private final String urlCode;
    private final Boolean active;
    private final Integer orderToShow;

    public AdminSubCategoryDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.active = subCategory.getActive();
        this.orderToShow = subCategory.getOrderToShow();
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
}
