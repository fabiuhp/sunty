package br.com.sunty.models.course.dto;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;

public class AdminEditCourseForm {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final int timeToFinishInHours;
    private final CourseVisibility visibility;
    private final String targetAudience;
    private final Long instructorId;
    private final String syllabus;
    private final String developedSkills;
    private final Long subCategoryId;

    public AdminEditCourseForm(Long id, String name, String urlCode, int timeToFinishInHours, CourseVisibility visibility, String targetAudience, Long instructorId, String syllabus, String developedSkills, Long subCategoryId) {
        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.visibility = visibility;
        this.targetAudience = targetAudience;
        this.instructorId = instructorId;
        this.syllabus = syllabus;
        this.developedSkills = developedSkills;
        this.subCategoryId = subCategoryId;
    }

    public Course toModel(Instructor instructor,SubCategory subCategory) {
        return new Course(
                this.id,
                this.name,
                this.urlCode,
                this.timeToFinishInHours,
                this.visibility,
                this.targetAudience,
                instructor,
                this.syllabus,
                this.developedSkills,
                subCategory
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public int getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    public CourseVisibility getVisibility() {
        return visibility;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }
}
