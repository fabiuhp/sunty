package br.com.sunty.models.course;

public class AdminCourseDto {
    private final String name;
    private final String urlCode;
    private final CourseVisibility visibility;

    public AdminCourseDto(Course course) {
        this.name = course.getName();
        this.urlCode = course.getUrlCode();
        this.visibility = course.getVisibility();
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public CourseVisibility getVisibility() {
        return visibility;
    }

    public String getVisibilityDisplayName() {
        return this.visibility.getDisplayName();
    }
}
