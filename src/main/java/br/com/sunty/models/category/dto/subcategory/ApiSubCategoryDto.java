package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.dto.ApiCourseDto;
import lombok.Value;

import java.util.List;

@Value
public class ApiSubCategoryDto {

    String name;
    String urlCode;
    String guideText;
    List<ApiCourseDto> courses;

    public ApiSubCategoryDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.guideText = subCategory.getGuideText();
        this.courses = subCategory.getPublicCourses().stream().map(ApiCourseDto::new).toList();
    }
}
