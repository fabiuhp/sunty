package br.com.sunty.dto;

import br.com.sunty.models.category.SubCategory;

public class CourseDTO {
    private Long id;
    private String name;
    private int timeToFinishInHours;
    private Long subCategoryId;
    private String subCategoryName;
    private String instructorName;

    public CourseDTO(Long id, String name, int timeToFinishInHours, Long subCategoryId, String subCategoryName, String instructorName) {
        this.id = id;
        this.name = name;
        this.timeToFinishInHours = timeToFinishInHours;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.instructorName = instructorName;
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
