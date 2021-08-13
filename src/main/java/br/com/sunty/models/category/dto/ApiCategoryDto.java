package br.com.sunty.models.category.dto;

import br.com.sunty.models.category.Category;

import java.util.List;

public class ApiCategoryDto {
    private final String name;
    private final String urlCode;
    private final String shortDescription;
    private final String guideText;
    private final Integer orderToShow;
    private final String hexHtmlColor;
    private final int totalCourses;
    private final List<ApiSubCategoryDto> subCategories;

    public ApiCategoryDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.shortDescription = category.getShortDescription();
        this.guideText = category.getGuideText();
        this.orderToShow = category.getOrderToShow();
        this.hexHtmlColor = category.getHexHtmlColor();
        this.totalCourses = category.getCoursesQuantity();
        this.subCategories = category.getActiveSubCategoryList().stream().map(ApiSubCategoryDto::new).toList();
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

    public int getTotalCourses() {
        return totalCourses;
    }

    public List<ApiSubCategoryDto> getSubCategories() {
        return subCategories;
    }
}
