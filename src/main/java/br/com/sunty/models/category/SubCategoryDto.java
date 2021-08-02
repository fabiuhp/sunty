package br.com.sunty.models.category;

import br.com.sunty.models.course.CourseDto;

import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryDto {

    private final String name;
    private final String urlCode;
    private final String guideText;
    private final List<CourseDto> courseDtos;

    public SubCategoryDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.guideText = subCategory.getGuideText();
        this.courseDtos = subCategory.getPublicCourses().stream().map(CourseDto::new).collect(Collectors.toList());
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

    public List<CourseDto> getCourseDtos() {
        return courseDtos;
    }
}
