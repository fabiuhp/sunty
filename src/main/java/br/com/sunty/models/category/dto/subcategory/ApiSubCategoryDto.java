package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.dto.ApiCourseDto;

import java.util.List;

public class ApiSubCategoryDto {

    private final String name;
    private final String urlCode;
    private final String guideText;
    private final List<ApiCourseDto> courses;

    public ApiSubCategoryDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.guideText = subCategory.getGuideText();
        this.courses = subCategory.getPublicCourses().stream().map(ApiCourseDto::new).toList();
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getGuideText() {
        return guideText;
    }

    public List<ApiCourseDto> getCourses() {
        return courses;
    }
}
