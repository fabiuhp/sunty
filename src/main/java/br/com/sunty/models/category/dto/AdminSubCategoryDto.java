package br.com.sunty.models.category.dto;

import br.com.sunty.models.category.SubCategory;

public class AdminSubCategoryDto {

    private final String name;
    private final String urlCode;
    private Boolean isActive;
    private final Integer orderToShow;

    public AdminSubCategoryDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.isActive = subCategory.getActive();
        this.orderToShow = subCategory.getOrderToShow();
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Integer getOrderToShow() {
        return orderToShow;
    }
}
