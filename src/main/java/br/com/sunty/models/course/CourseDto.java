package br.com.sunty.models.course;

public class CourseDto {
    private Long id;
    private String name;
    private int timeToFinishInHours;
    private Long subCategoryId;
    private String subCategoryName;
    private String instructorName;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
        this.subCategoryId = course.getSubCategory().getId();
        this.subCategoryName = course.getSubCategory().getName();
        this.instructorName = course.getInstructor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public String getInstructorName() {
        return instructorName;
    }
}
