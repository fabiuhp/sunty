package br.com.sunty.models.category.dto.subcategory;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.dto.ApiCourseDetailsDto;

import java.util.List;

public class ApiSubCategoryDetailsDto {

    private final String name;
    private final String urlCode;
    private final List<ApiCourseDetailsDto> coursesDetails;

    public ApiSubCategoryDetailsDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.coursesDetails = subCategory.getCourseList().stream().map(ApiCourseDetailsDto::new).toList();
    }

    public String getName() {
        return name;
    }

    public List<ApiCourseDetailsDto> getCoursesDetails() {
        return coursesDetails;
    }

    public String getUrlCode() {
        return urlCode;
    }
}