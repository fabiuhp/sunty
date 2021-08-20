package br.com.sunty.models.course.dto;

import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;

public class AdminEditCourseView {

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

    public AdminEditCourseView(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.urlCode = course.getUrlCode();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
        this.visibility = course.getVisibility();
        this.targetAudience = course.getTargetAudience();
        this.instructorId = course.getInstructorId();
        this.syllabus = course.getSyllabus();
        this.developedSkills = course.getDevelopedSkills();
        this.subCategoryId = course.getSubCategoryId();
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
