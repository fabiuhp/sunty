package br.com.sunty.models.category.dto.category;

import br.com.sunty.models.category.Category;
import br.com.sunty.models.category.dto.subcategory.ApiSubCategoryDto;
import lombok.Value;

import java.util.List;

@Value
public class ApiCategoryDto {
    String name;
    String urlCode;
    String shortDescription;
    String guideText;
    Integer orderToShow;
    String hexHtmlColor;
    int totalCourses;
    List<ApiSubCategoryDto> subCategories;

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

    public int getTotalCourses() {
        return totalCourses;
    }

    public List<ApiSubCategoryDto> getSubCategories() {
        return subCategories;
    }
}
