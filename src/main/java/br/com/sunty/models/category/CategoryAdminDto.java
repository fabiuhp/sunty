package br.com.sunty.models.category;

import java.util.List;

public class CategoryAdminDto {
    private final String name;
    private final String urlCode;
    private final String shortDescription;
    private final String guideText;
    private final boolean isActive;
    private final Integer orderToShow;
    private final String pathImg;
    private final String hexHtmlColor;
    private final List<SubCategoryDto> subCategoryDtoList;

    public CategoryAdminDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.shortDescription = category.getShortDescription();
        this.guideText = category.getGuideText();
        this.isActive = category.getActive();
        this.orderToShow = category.getOrderToShow();
        this.pathImg = category.getPathImg();
        this.hexHtmlColor = category.getHexHtmlColor();
        this.subCategoryDtoList = category.getSubCategoryList().stream().map(SubCategoryDto::new).toList();
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

    public String getHexHtmlColor() {
        return hexHtmlColor;
    }

    public String getGuideText() {
        return guideText;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public List<SubCategoryDto> getSubCategoryDtoList() {
        return subCategoryDtoList;
    }
}