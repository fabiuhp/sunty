package br.com.sunty.models.course.dto;

import br.com.sunty.models.category.SubCategory;
import br.com.sunty.models.course.Course;
import br.com.sunty.models.course.CourseVisibility;
import br.com.sunty.models.instructor.Instructor;
import br.com.sunty.repository.course.CourseRepository;
import br.com.sunty.repository.instructor.InstructorRepository;
import br.com.sunty.repository.subcategory.SubCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    public static Course toModel(CourseRepository courseRepository, InstructorRepository instructorRepository, SubCategoryRepository subCategoryRepository, AdminEditCourseView adminEditCourseView) {
        Course course = courseRepository.findById(adminEditCourseView.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Instructor instructor = instructorRepository.findById(adminEditCourseView.getInstructorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        SubCategory subCategory = subCategoryRepository.findById(adminEditCourseView.getSubCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        course.setId(adminEditCourseView.getId());
        course.setName(adminEditCourseView.getName());
        course.setUrlCode(adminEditCourseView.getUrlCode());
        course.setTimeToFinishInHours(adminEditCourseView.getTimeToFinishInHours());
        course.setVisibility(adminEditCourseView.getVisibility());
        course.setTargetAudience(adminEditCourseView.getTargetAudience());
        course.setInstructor(instructor);
        course.setSyllabus(adminEditCourseView.getSyllabus());
        course.setDevelopedSkills(adminEditCourseView.getDevelopedSkills());
        course.setSubCategory(subCategory);
        return course;
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
