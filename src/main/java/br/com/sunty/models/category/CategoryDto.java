package br.com.sunty.models.category;

import java.util.List;

public class CategoryDto {
    private final String name;
    private final String urlCode;
    private final String shortDescription;
    private final String guideText;
    private final Integer orderToShow;
    private final String hexHtmlColor;
    private final int totalCourse;
    private final List<SubCategoryDto> subCategories;

    public CategoryDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.shortDescription = category.getShortDescription();
        this.guideText = category.getGuideText();
        this.orderToShow = category.getOrderToShow();
        this.hexHtmlColor = category.getHexHtmlColor();
        this.totalCourse = category.getCoursesQuantity();
        this.subCategories = category.getActiveSubCategoryList().stream().map(SubCategoryDto::new).toList();
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

    public int getTotalCourse() {
        return totalCourse;
    }

    public List<SubCategoryDto> getSubCategories() {
        return subCategories;
    }
}
