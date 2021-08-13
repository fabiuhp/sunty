package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.SubCategory;

public class AdminEditSubCategoryView {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final Boolean active;
    private final Integer orderToShow;
    private final String guideText;
    private final String shortDescription;
    private final Long categoryId;
    private final String categoryName;

    public AdminEditSubCategoryView(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.active = subCategory.getActive();
        this.orderToShow = subCategory.getOrderToShow();
        this.guideText = subCategory.getGuideText();
        this.shortDescription = subCategory.getShortDescription();
        this.categoryId = subCategory.getCategoryId();
        this.categoryName = subCategory.getCategoryName();
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

    public String getCategoryName() {
        return categoryName;
    }
}
